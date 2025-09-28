package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;
import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class HomePage {

    // Variables
    public WebDriver driver;

    // Locators
    private final By headerPanel = By.cssSelector("span[data-testid=\"herobanner-title1\"]");
    private final By destinationField = By.cssSelector("input[class=\"b915b8dc0b\"]");
    private final By datesField = By.cssSelector("button[data-testid=\"searchbox-dates-container\"]");
    private final By datesPicker = By.cssSelector("nav[data-testid=\"datepicker-tabs\"]");
    private final By searchButton = By.cssSelector("button[type=\"submit\"]");

    private By getCheckInDate(String inDate) {
        return By.cssSelector("span[data-date='" + inDate + "']");
    }

    private By getCheckOutDate(String outDate) {
        return By.cssSelector("span[data-date='" + outDate + "']");
    }

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public SearchPage clickSearchButton() {
        highlightElement(driver, driver.findElement(searchButton));
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public HomePage enterDestination(String text) {
        highlightElement(driver, driver.findElement(destinationField));
        driver.findElement(destinationField).sendKeys(text);
        return this;
    }

    public HomePage enterDates(String inDate, String outDate) {
        highlightElement(driver, driver.findElement(datesField));
        driver.findElement(datesField).click();
        driver.findElement(datesPicker).findElement(getCheckInDate(inDate)).click();
        driver.findElement(getCheckOutDate(outDate)).click();
        return this;
    }


    // Validations
    public HomePage verifyHeader() {
        explicitWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(headerPanel));
        highlightElement(driver, driver.findElement(headerPanel));
        assertTrue(driver.findElement(headerPanel).isDisplayed());
        return this;
    }

}
