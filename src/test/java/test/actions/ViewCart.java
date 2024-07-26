package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ViewCart {

    private WebDriver driver;
    private WebDriverWait wait;

    public ViewCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Clicks the "View Cart" button.
     */
    public void clickViewCart() {
        try {
            WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xoo-wsc-ft-btn.xoo-wsc-ft-btn-cart")));
            viewCartButton.click();
            Reporter.log("Clicked 'View Cart' button.", true);
        } catch (Exception e) {
            Reporter.log("Error clicking 'View Cart' button: " + e.getMessage(), true);
        }
    }
}
