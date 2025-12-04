import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubCategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerLink = By.cssSelector("h1.title");
    private By subCategoryPageLink = By.cssSelector
            ("li.category-2 > a[href*='subcategory-c-2']");

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getSubCategoryHeaderText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLink));
        return pageHeader.getText();
    }

}
