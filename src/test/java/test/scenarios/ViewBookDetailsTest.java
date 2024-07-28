package test.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.actions.ViewBookDetails;
import test.actions.ViewListOfBooks;
import test.utils.TheWebDriverManager;

public class ViewBookDetailsTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = TheWebDriverManager.getDriver();
        ViewListOfBooks.scrollToBooks(driver);
    }

    @DataProvider(name = "bookUrls")
    public Object[][] createBookUrls() {
        return new Object[][] {
                {"https://legendabookstore.com/home/product/9789778350623/"},
        };
    }

    @Test(dataProvider = "bookUrls")
    public void testClickOnBook(String bookUrl) {
        ViewBookDetails.clickOnBook(driver, bookUrl);
    }

    @AfterClass
    public void tearDown() {
        TheWebDriverManager.quitDriver();
    }
}
