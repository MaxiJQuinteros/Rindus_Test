package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By priceOfItemLocator;
    private By quantityOfItemLocator;
    private By itemOverWrapLocator = By.className("sc-list-item-overwrap");
    private By listOfItemsLocator = By.xpath("//*[@data-name=\"Active Items\"]/*[@data-item-index]");
    private By subtotalPriceLocator = By.id("sc-subtotal-amount-buybox");
    private By amountInputLocator;
    private By updateButtonLocator;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    ///This method parse the prices of the elements we select and returns them on a double variable so they can be compared later
    private double getPriceAmount(By element) throws Exception {
        String[] priceString = this.getText(element).split("[$]");
        double realPrice = Math.round(Double.parseDouble(priceString[1]) * 100) / 100.0;
        return realPrice;
    }

    ///I create this method so if there are more than one item on the cart list this method could be used to assert the price of all of them
    public boolean correctPrice() throws Exception {
        this.waitUntilIsNotDisplayed(itemOverWrapLocator); ///This wait method is being used so when the amount of an item has been changed it has enough time to get the proper prices from the elements on screen.
        double finalPrice = 0; /// This variable store the amount of all items prices
        int amountOfItemsOnCart = this.getAmountOfLocators(listOfItemsLocator); /// We store the amount of locators, so we can know the number of items listed on the cart
        double subtotalPrice = getPriceAmount(subtotalPriceLocator); /// The getPriceAmount method is used on the subtotal price element of the cart
        for (int i = 1; i < amountOfItemsOnCart + 1; i++) {
            priceOfItemLocator = By.xpath("//*[@data-item-index=\"" + i + "\"]/div[4]/div/div[2]/p/span"); ///As seen on methods of another classes, the variable is instanced here so the proper element could be got from the list of items
            quantityOfItemLocator = By.xpath("//*[@data-item-index=\"" + i + "\"]//*//*[@data-a-class=\"quantity\"]/span/span/span[2]"); ///As seen on methods of another classes, the variable is instanced here so the proper element could be got from the list of items
            double itemPrice = getPriceAmount(priceOfItemLocator); ///The getPriceAmount method is used to get the price displayed on this single item on the cart
            int itemQuantity = Integer.parseInt(this.getText(quantityOfItemLocator)); ///The quantity of that item is stored, so we can know the proper prince on the item
            finalPrice = finalPrice + (itemPrice * itemQuantity); ///The item's total price is added to the final price and if there are more items on the list the loop will continue to add them
        }
        if (finalPrice == subtotalPrice) {
            return true;
        }
        return false;
    }

    ///Same as the previous method, I create this method so if more than one item is displayed on the cart the quantity of the desired item could be changed.
    ///There is an issue with how the field for more than 10 units handle the clearing of values inside it
    public void changeQuantityOfItem(int quantity, int position) throws Exception {
        quantityOfItemLocator = By.xpath("//*[@data-item-index=\"" + position + "\"]//*//*[@id=\"quantity\"]"); ///As seen on methods of another classes, the variable is instanced here so the proper element could be got from the list of items. This one references the quantity dropdown locator
        amountInputLocator = By.xpath("//*[@data-item-index=\"" + position + "\"]//*[@name=\"quantityBox\"]"); ///As seen on methods of another classes, the variable is instanced here so the proper element could be got from the list of items. This one references the amount input box locator
        updateButtonLocator = By.xpath("//*[@data-item-index=\"" + position + "\"]//*[@class=\"sc-action-quantity\"]//*[@data-action=\"update\"]"); ///As seen on methods of another classes, the variable is instanced here so the proper element could be got from the list of items. This one references the update button locator
        if (quantity >= 10) {
            this.selectByIndex(quantityOfItemLocator, 10); ///We select the 10 option so the input field can be displayed
            this.clear(amountInputLocator); ///The input field is clear of the previous value
            this.inputText(amountInputLocator, String.valueOf(quantity)); ///We enter the new value on the input field
            this.waitUntilIsNotDisplayed(itemOverWrapLocator); ///We wait until the OverWrap on the item is not longer displayed
            this.click(updateButtonLocator); ///We click the update button so the new quantity updates the price
        } else {
            this.selectByIndex(quantityOfItemLocator, quantity);
        }
    }
}
