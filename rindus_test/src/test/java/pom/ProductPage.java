package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By quantityListLocator;
    private By selectQuantityLocator = By.xpath("//*[@id=\"selectQuantity\"]//*[@class=\"a-button-inner\"]");
    private By addToCartButtonLocator = By.id("add-to-cart-button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    ///Just as the selectItemFromResults method this one instance the variable on the method, a Select method couldn't be implemented properly.
    public void selectDesiredQuantity(int quantity) throws Exception {
        quantityListLocator = By.xpath("//*[@role=\"listbox\"]/li[" + quantity + "]");
        this.click(selectQuantityLocator);
        this.click(quantityListLocator);
    }

    public void addToCart() throws Exception {
        this.click(addToCartButtonLocator);
    }
}
