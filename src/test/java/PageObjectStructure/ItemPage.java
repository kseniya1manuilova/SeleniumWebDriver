package PageObjectStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By addItemToChart = By.cssSelector
            ("button[name='add_cart_product']");

    private By selectItemSize = By.name("options[Size]");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addItemToCart() {
        WebElement subCategoriesLink = wait.until(ExpectedConditions.elementToBeClickable(addItemToChart));
        subCategoriesLink.click();
    }

    public void selectItemSize() {
        WebElement itemSize = wait.until(ExpectedConditions.elementToBeClickable(selectItemSize));
        Select select = new Select(itemSize);
        select.selectByVisibleText("Large +$5");
    }
}
