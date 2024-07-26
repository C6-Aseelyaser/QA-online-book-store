package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class AddBookToCart {

    /**
     * Clicks the "Add to cart" button for a specified book.
     *
     * @param driver             the WebDriver instance
     * @param bookUrl            the URL of the book to click
     * @param buttonCssSelector  the CSS selector for the "Add to cart" button
     */
    public static void addBookToCart(WebDriver driver, String bookUrl, String buttonCssSelector) {
        // First, click on the book
        ViewBookDetails.clickOnBook(driver, bookUrl);

        // Then, click on the "Add to cart" button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(buttonCssSelector)));
            addToCartButton.click();
            Reporter.log("Clicked 'Add to Cart' button with CSS selector: " + buttonCssSelector, true);
        } catch (Exception e) {
            Reporter.log("Error clicking 'Add to Cart' button with CSS selector: " + buttonCssSelector + " - " + e.getMessage(), true);
        }
    }
}
