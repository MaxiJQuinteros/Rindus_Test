package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AmazonTestStepDef extends TestBase {
    @Given("I am on Amazon home page")
    public void iAmOnAmazonHomePage() throws Exception {
        Assert.assertTrue(homePage.amazonHomePageIsDisplayed());
    }

    @When("I search for {string}")
    public void iSearchForItem(String item) throws Exception {
        homePage.searchForItem(item);
    }


    @And("I add {int} of the item on position {int} to the cart")
    public void iAddOfTheItemOnPositionToTheCart(int quantity, int position) throws Exception {
        resultsPage.selectItemFromResult(position);
        productPage.selectDesiredQuantity(quantity);
        productPage.addToCart();
    }

    @And("I open the cart window")
    public void iOpenTheCartWindow() throws Exception {
        smartCartPage.openCart();
    }

    @Then("the quantity and price of the product is correct")
    public void theQuantityAndPriceOfTheProductIsCorrect() throws Exception {
        Assert.assertTrue(cartPage.correctPrice());
    }

    @When("I change in {int} the quantity of the position {int} product")
    public void iChangeInTheQuantityOfThePositionProduct(int quantity, int position) throws Exception {
        cartPage.changeQuantityOfItem(quantity, position);
    }
}
