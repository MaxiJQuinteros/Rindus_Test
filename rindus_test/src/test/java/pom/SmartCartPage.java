package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartCartPage extends BasePage {
    private By cartLocator = By.id("nav-cart");

    public SmartCartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() throws Exception {
        this.click(cartLocator);
    }
}
