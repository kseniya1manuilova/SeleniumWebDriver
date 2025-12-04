import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartPageLink = By.cssSelector("#cart a.link");

    private By emptyCartText = By.cssSelector
            ("#checkout-cart-wrapper em");

    private By orderSummaryText = By.xpath("//h2[@class='title' and text()='Order Summary']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickCartPage() {
        driver.findElement(cartPageLink).click();
    }

    public String getEmptyCartHeaderText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartText));
        return pageHeader.getText();
    }

    public String getOrderSummaryText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSummaryText));
        return pageHeader.getText();
    }
}
