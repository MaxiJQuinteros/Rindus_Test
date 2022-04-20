package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends BasePage {
    private By amazonLogo = By.id("nav-logo-sprites");
    private By searchBarLocator = By.id("twotabsearchtextbox");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    /// In this method we corroborate that the Amazon logo is displayed, letting us know that we have reached the proper site
    public boolean amazonHomePageIsDisplayed() throws Exception {
        return this.isDisplayed(amazonLogo);
    }

    /// In this method we just input data on the search bar
    public void searchForItem(String input) throws Exception {
        this.clear(searchBarLocator);
        this.inputText(searchBarLocator, input);
        this.submit(searchBarLocator);
    }
}
