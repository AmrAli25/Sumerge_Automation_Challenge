package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class SearchPage {

    // Variables
    private static WebDriver driver;

    // Locators
    private final By hotelAvailability = By.cssSelector("a[data-testid=\"availability-cta-btn\"][href*=\"royal-tulip-alexandria\"]");

    // Constructor
    public SearchPage(WebDriver driver) {
        SearchPage.driver = driver;
    }

    // Actions
    public DetailsPage clickOnWantedHotel() {
        explicitWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(hotelAvailability));
        new Actions(driver).scrollToElement(driver.findElement(hotelAvailability));
        highlightElement(driver, driver.findElement(hotelAvailability));
        driver.findElement(hotelAvailability).click();
        return new DetailsPage(driver);

    }
}
