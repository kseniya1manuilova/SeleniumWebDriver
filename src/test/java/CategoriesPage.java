import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CategoriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By categoriesPageLink = By.cssSelector
            ("li.category-1");

    private By subCategoryink = By.cssSelector
            ("li.category-2 > a[href*='subcategory-c-2']");

    private By yellowDuckLink = By.cssSelector
            ("a[title='Yellow Duck']");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openCategoriesPage() {
        driver.findElement(categoriesPageLink).click();
    }


    public void openSubCategoryDropDown() {
        WebElement categoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesPageLink));

        Actions actions = new Actions(driver);
        actions.moveToElement(categoryElement).perform();

    }

    public void clickSubCategory() {
        WebElement subCategoriesLink = wait.until(ExpectedConditions.elementToBeClickable(subCategoryink));
        subCategoriesLink.click();
    }

    public void openYellowDuckInfoPage() {
        WebElement subCategoriesLink = wait.until(ExpectedConditions.elementToBeClickable(yellowDuckLink));
        subCategoriesLink.click();
    }

    public void categoriesPageContent(){
        List<WebElement> children = driver.findElements(By.cssSelector
                (".listing-wrapper .product.column.shadow.hover-light"));
        Assert.assertFalse(children.isEmpty());
    }
}
