package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static WebDriverWait explicitWait(WebDriver driver, long timeInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
    }

    public static void implicitWait(WebDriver driver, long timeInSec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    public static void switchToTab(WebDriver driver, int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

}
