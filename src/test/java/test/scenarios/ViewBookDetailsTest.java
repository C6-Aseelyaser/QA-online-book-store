package test.scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.actions.ViewBookDetails;
import test.actions.ViewListOfBooks;

import java.time.Duration;

public class ViewBookDetailsTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://legendabookstore.com/");
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
        if (driver != null) {
            driver.quit();
        }
    }
}
