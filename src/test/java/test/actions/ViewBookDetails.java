package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ViewBookDetails {

    /**
     * Clicks on a book given its URL.
     *
     * @param driver  the WebDriver instance
     * @param bookUrl the URL of the book to click
     */
    public static void clickOnBook(WebDriver driver, String bookUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement bookElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bd-producttitle-4 a[href='" + bookUrl + "']")));
            bookElement.click();
            Reporter.log("Clicked on the book with URL: " + bookUrl, true);
        } catch (Exception e) {
            Reporter.log("Failed to click on the book with URL: " + bookUrl + " - " + e.getMessage(), true);
        }
    }
}
