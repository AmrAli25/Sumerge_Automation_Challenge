package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;
import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class ConfirmationPage {

    // Variables
    private static WebDriver driver;

    // Locators
    private final By hotelHeader = By.cssSelector("h1[class=\"e7addce19e\"]");

    // Constructor
    public ConfirmationPage(WebDriver driver) {
        ConfirmationPage.driver = driver;
    }


    // Actions

    // Validations
    public ConfirmationPage verifyHotelName() {
        explicitWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(hotelHeader));
        highlightElement(driver, driver.findElement(hotelHeader));
        assertEquals(driver.findElement(hotelHeader).getText(), "Tolip Hotel Alexandria");
        return this;
    }

}
