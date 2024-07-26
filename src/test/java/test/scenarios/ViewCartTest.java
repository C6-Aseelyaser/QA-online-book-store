package test.scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.actions.AddBookToCart;
import test.actions.ViewCart;
import test.actions.ViewListOfBooks;


import java.time.Duration;

public class ViewCartTest {

    private WebDriver driver;
    private ViewCart viewCart;

    @DataProvider(name = "bookData")
    public Object[][] createBookData() {
        return new Object[][] {
                {"https://legendabookstore.com/home/product/9789778350623/", ".bd-productbuy-5"}
        };
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://legendabookstore.com/");
        ViewListOfBooks.scrollToBooks(driver);
    }

    @Test(dataProvider = "bookData")
    public void testAddBookToCartAndViewCart(String bookUrl, String addToCartButtonCssSelector) {
        AddBookToCart.addBookToCart(driver, bookUrl, addToCartButtonCssSelector);
        viewCart = new ViewCart(driver);
        viewCart.clickViewCart();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
