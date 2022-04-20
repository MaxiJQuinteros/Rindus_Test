package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import runner.browserManager.DriverManager;
import runner.browserManager.DriverManagerFactory;
import runner.browserManager.DriverType;

/// The Hooks class manage the different @Before and @Afters of the scenarios, this way the code can be change in this single class instead of the glue classes for those scenarios
public class Hooks {
    private static WebDriver driver;
    private static int numberOfCase = 0;
    private DriverManager driverManager;

    ///Here in the @Before tag I handle the setUp method so the driver can initiate, the driverManager is set so if we want to run the test cases in other browsers we just change the DriverType to the desired enum and the DriverManagerFactory just handles it
    @Before
    public void setUp() {
        numberOfCase++;
        System.out.println("Executing test case scenario number: " + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
    }
    ///On the @After tag I just let the system to show the number of cases executed and close the webdriver
    @After
    public void tearDown() {
        System.out.println("Scenario " + numberOfCase + " was executed properly");
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
