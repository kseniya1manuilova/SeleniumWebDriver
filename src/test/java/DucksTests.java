import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DucksTests extends HomePage {

    @Test
    public void openHomePageScreenTest() {
        openHomePage();
        clickHomePage();

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Online Store | My Store");

    }

    @Test
    public void openCategoriesScreenTest() {
        CategoriesPage categoryPage = new CategoriesPage(driver);
        categoryPage.openCategoriesPage();

        WebElement pageHeader = driver.findElement(By.cssSelector("h1.title"));

        Assert.assertEquals(pageHeader.getText(), "Rubber Ducks");
    }

    @Test
    public void openSubCategoriesScreenTest() {
        CategoriesPage categoryPage = new CategoriesPage(driver);
        SubCategoriesPage subCategoryPage = new SubCategoriesPage(driver);

        categoryPage.openSubCategoryDropDown();
        categoryPage.clickSubCategory();

        Assert.assertEquals(subCategoryPage.getSubCategoriesHeaderText(), "Subcategory");
    }


    @Test
    public void openCatalogPageTest() {
        clickHomePage();

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Online Store | My Store");
    }

    @Test
    public void emptyCartTest() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartPage();

        Assert.assertEquals(cartPage.getEmptyCartHeaderText(), "There are no items in your cart.");
    }

    @Test
    public void cartHasItemTest() {
        CategoriesPage categoryPage = new CategoriesPage(driver);
        ItemPage itemPage = new ItemPage(driver);
        CartPage cartPage = new CartPage(driver);

        categoryPage.openCategoriesPage();
        categoryPage.openYellowDuckInfoPage();
        itemPage.selectItemSize();
        itemPage.addItemToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(driver -> {
            WebElement quantity = driver.findElement(By.cssSelector("span.quantity"));
            return Integer.parseInt(quantity.getText()) > 0;
        });
        cartPage.clickCartPage();
        Assert.assertEquals(cartPage.getOrderSummaryText(), "Order Summary");
    }
}
