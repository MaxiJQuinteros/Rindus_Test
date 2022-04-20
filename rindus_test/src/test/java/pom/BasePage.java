package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

///The base page handles all the common methods the rest of the pages of the site inherits
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            throw new Exception("Cannot click " + element + " element");
        }
    }

    public boolean isDisplayed(By element) throws Exception {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Element " + element + " could not be found");
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            throw new Exception("Could not get text from " + element + " element");
        }
    }

    public void inputText(By element, String input) throws Exception {
        try {
            driver.findElement(element).sendKeys(input);
        } catch (Exception e) {
            throw new Exception("Could not input text on element " + element);
        }
    }

    public void submit(By element) throws Exception {
        try {
            driver.findElement(element).submit();
        } catch (Exception e) {
            throw new Exception("Could not submit element " + element);
        }
    }

    public void clear(By element) throws Exception {
        try {
            driver.findElement(element).clear();
        } catch (Exception e) {
            throw new Exception("Could not clear element " + element);
        }
    }

    public int getAmountOfLocators(By element) throws Exception {
        try {
            return driver.findElements(element).size();
        } catch (Exception e) {
            throw new Exception("Could not find elements");
        }
    }

    public void selectByIndex(By element, int index) throws Exception {
        try {
            new Select(driver.findElement(element)).selectByIndex(index);
        } catch (Exception e) {
            throw new Exception("Could not select element " + element + " on index " + index);
        }
    }

    public void waitUntilIsNotDisplayed(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
