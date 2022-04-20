package tests;

import org.openqa.selenium.WebDriver;
import pom.*;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected AmazonHomePage homePage = new AmazonHomePage(driver);
    protected ResultsPage resultsPage = new ResultsPage(driver);
    protected ProductPage productPage = new ProductPage(driver);
    protected SmartCartPage smartCartPage = new SmartCartPage(driver);
    protected CartPage cartPage = new CartPage(driver);
}
