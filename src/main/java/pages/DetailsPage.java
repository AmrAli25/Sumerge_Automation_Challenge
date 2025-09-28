package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Helper;

import static org.testng.Assert.assertEquals;
import static utils.Helper.explicitWait;
import static utils.Helper.highlightElement;

public class DetailsPage {

    // Variables
    private static WebDriver driver;

    // Locators

    private final By checkInDate = By.xpath("//span[@class='be2db1c937'][text()='Wed, Oct 1']");
    private final By checkOutDate = By.xpath("//span[@class='be2db1c937'][text()='Tue, Oct 14']");
    private final By bedSelection = By.xpath("//input[@type=\"radio\"][@value=\"1\"][1]");
    private final By amount = By.xpath("//option[@value=\"1\"][1]");
    private final By reserveButton = By.cssSelector("span[class=\"bui-button__text js-reservation-button__text\"]");

    // Constructor
    public DetailsPage(WebDriver driver) {
        DetailsPage.driver = driver;
    }

    // Actions
    public DetailsPage selectBeds() {
        driver.findElement(bedSelection).click();
        return this;
    }

    public DetailsPage selectAmount() {
        driver.findElement(amount).click();
        return this;
    }

    public ConfirmationPage clickReserveBtn() {
        highlightElement(driver, driver.findElement(reserveButton));
        driver.findElement(reserveButton).click();
        return new ConfirmationPage(driver);
    }

    // Validations
    public DetailsPage verifyDates() {
        Helper.switchToTab(driver, 1);
        explicitWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(checkInDate));
        new Actions(driver).scrollToElement(driver.findElement(checkInDate));
        assertEquals(driver.findElement(checkInDate).getText(), "Wed, Oct 1");
        assertEquals(driver.findElement(checkOutDate).getText(), "Tue, Oct 14");
        Helper.highlightElement(driver, driver.findElement(checkInDate));
        Helper.highlightElement(driver, driver.findElement(checkOutDate));
        return this;
    }
}
