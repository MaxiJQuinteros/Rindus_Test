package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage {
    private By resultListLocator;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    ///I have manage to get the location of items selecting the div with the position desired. This prompt us to instance the variable on the method due to the position information being in that instant
    ///Handling it this way we can avoid using a for loop
    public void selectItemFromResult(int position) throws Exception {
        resultListLocator = By.xpath("//*[@id=\"search\"]//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div[@data-index=\"" + position + "\"]");
        this.click(resultListLocator);
    }


}
