import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By categoryPageLink = By.cssSelector
            ("li.category-1");

    private By subCategoryLink = By.cssSelector
            ("li.category-2 > a[href*='subcategory-c-2']");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openCategoryPage() {
        driver.findElement(categoryPageLink).click();
    }


    public void openSubCategoryDropDown() {
        WebElement categoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryPageLink));

        Actions actions = new Actions(driver);
        actions.moveToElement(categoryElement).perform();

    }

    public void clickSubCategory() {
        WebElement subCategoriesLink = wait.until(ExpectedConditions.elementToBeClickable(subCategoryLink));
        subCategoriesLink.click();
    }

}
