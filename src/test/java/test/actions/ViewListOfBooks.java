package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ViewListOfBooks {

    public static void scrollToBooks(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item.active")));
            js.executeScript("arguments[0].scrollIntoView(true);", section);
            Reporter.log("Scrolled to the books section.", true);
        } catch (Exception e) {
            Reporter.log("Failed to scroll to the books section: " + e.getMessage(), true);
        }
    }
}
