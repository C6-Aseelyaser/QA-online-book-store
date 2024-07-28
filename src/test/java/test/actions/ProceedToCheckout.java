package test.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ProceedToCheckout {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProceedToCheckout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Clicks the "Proceed to Checkout" button and completes the checkout process.
     */
    public void proceedToCheckout() {
        try {
            clickProceedToCheckoutButton();
            fillBillingDetails();
            agreeToTerms();
            placeOrder();
            verifyOrderConfirmation();
        } catch (Exception e) {
            Reporter.log("Error during checkout: " + e.getMessage(), true);
        }
    }

    private void clickProceedToCheckoutButton() {
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.bd-button-22[href='https://legendabookstore.com/home/checkout/']")));
        proceedToCheckoutButton.click();
        Reporter.log("Clicked 'Proceed to Checkout' button.", true);
    }

    private void fillBillingDetails() {
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing_first_name")));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("billing_last_name"));
        lastName.sendKeys("Doe");

        WebElement company = driver.findElement(By.id("billing_company"));
        company.sendKeys("Company Inc.");

        WebElement address1 = driver.findElement(By.id("billing_address_1"));
        address1.sendKeys("1234 Elm Street");

        WebElement address2 = driver.findElement(By.id("billing_address_2"));
        address2.sendKeys("Apt 567");

        WebElement city = driver.findElement(By.id("billing_city"));
        city.sendKeys("Amman");

        WebElement phone = driver.findElement(By.id("billing_phone"));
        phone.sendKeys("+962123456789");

        WebElement email = driver.findElement(By.id("billing_email"));
        email.sendKeys("john.doe@joe.com");

        Reporter.log("Filled in billing details.", true);
    }

    private void agreeToTerms() {
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
            Reporter.log("Checked 'Terms' checkbox.", true);
        }
    }

    private void placeOrder() {
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
        placeOrderButton.click();
        Reporter.log("Clicked 'Place Order' button.", true);
    }

    private void verifyOrderConfirmation() {
        WebElement orderConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-thankyou-order-received")));
        if (orderConfirmationMessage.getText().contains("Thank you. Your order has been received.")) {
            Reporter.log("Order placed successfully: " + orderConfirmationMessage.getText(), true);
        } else {
            Reporter.log("Order confirmation not received.", true);
        }
    }
}
