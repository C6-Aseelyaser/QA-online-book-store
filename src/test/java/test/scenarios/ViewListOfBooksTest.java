package test.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.actions.ViewListOfBooks;
import test.utils.WebDriverManager;

public class ViewListOfBooksTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
    }

    @Test
    public void testScrollToBooks() {
        ViewListOfBooks.scrollToBooks(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
