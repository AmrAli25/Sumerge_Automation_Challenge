package websitebase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import utils.CsvDataProvider;
import utils.EventListenerManger;
import utils.TestData;

import java.util.Iterator;
import java.util.List;

public class BaseTest {

    protected HomePage homePage;
    private WebDriver driver;


    @BeforeMethod(description = "Setup the Browser Instance")
    public void beforeMethod() {
        driver = createWebDriverWithListener(new ChromeDriver(getChromeOptions()));
        homePage = goToHomePage();
    }


    @AfterMethod(description = "Tear Down the Browser Instance")
    public void afterMethod() {
        driver.quit();
    }


    public HomePage goToHomePage() {
        driver.get("https://www.booking.com");
        return new HomePage(driver);
    }

    /**
     * Create a Browser instance with listeners to make Reporting files
     *
     * @param driver (The driver instance type you want to use)
     * @return The driver type to be used from WebDriver --> Decorated type
     */
    private WebDriver createWebDriverWithListener(WebDriver driver) {
        EventListenerManger eventListener = new EventListenerManger();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        return decorator.decorate(driver);
    }

    /**
     * Add the options to the driver instance you initialized
     *
     * @return Options you choose for the browser driver instance used
     */
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--disable-search-engine-choice-screen",
                "--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching," +
                        "OptimizationTargetPrediction,OptimizationHints"/*  ,"--headless=new"*/);
        return options;
    }

    /***
     * This is the test data provider for dynamic testing using any wanted data from CSV file as mentioned
     * @return a list of the data from CSV to be used for testing
     */

    @DataProvider(name = "csvData")
    public Iterator<Object[]> provideData() {
        List<TestData> dataList = CsvDataProvider.loadTestData("src/test/java/testDataFiles/testdata.csv");
        return dataList.stream()
                .map(data -> new Object[]{data})
                .iterator();
    }

}
