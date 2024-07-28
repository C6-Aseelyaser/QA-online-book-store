package test.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.actions.AddBookToCart;
import test.actions.ProceedToCheckout;
import test.actions.ViewCart;
import test.actions.ViewListOfBooks;
import test.utils.WebDriverManager;

public class ProceedToCheckoutTest {

    private WebDriver driver;
    private ViewCart viewCart;
    private ProceedToCheckout proceedToCheckout;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();

        viewCart = new ViewCart(driver);
        proceedToCheckout = new ProceedToCheckout(driver);

        ViewListOfBooks.scrollToBooks(driver);

        String bookUrl = "https://legendabookstore.com/home/product/9789778350623/";
        String addToCartButtonCssSelector = ".bd-productbuy-5";
        AddBookToCart.addBookToCart(driver, bookUrl, addToCartButtonCssSelector);
    }

    @Test
    public void testViewCartAndCheckoutProcess() {
        viewCart.clickViewCart();
        proceedToCheckout.proceedToCheckout();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
