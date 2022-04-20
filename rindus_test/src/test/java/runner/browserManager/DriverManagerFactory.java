package runner.browserManager;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager = null;

        switch (type) {

            case CHROME:
                driverManager = new ChromeDriverManager();
                break;

            default:
                System.out.println("Invalid browser selected");
                break;
        }

        return driverManager;

    }
}
