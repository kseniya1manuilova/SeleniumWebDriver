package PageObjectStructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PageObjectStructure.Locators.getLocator;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

//    private By cartPageLink = By.cssSelector("#cart a.link");
//
//    private By emptyCartText = By.cssSelector
//            ("#checkout-cart-wrapper em");
//
//    private By orderSummaryText = By.xpath("//h2[@class='title' and text()='Order Summary']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickCartPage() {
        driver.findElement(getLocator("CartPage.CartLink")).click();
    }

    public String getEmptyCartHeaderText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator
                ("CartPage.EmptyCartText")));
        return pageHeader.getText();
    }

    public String getOrderSummaryText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator
                ("CartPage.OrderSummaryText")));
        return pageHeader.getText();
    }
}
