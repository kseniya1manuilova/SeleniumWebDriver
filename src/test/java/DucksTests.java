import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.openCategoryPage();

        WebElement pageHeader = driver.findElement(By.cssSelector("h1.title"));

        Assert.assertEquals(pageHeader.getText(), "Rubber Ducks");
    }

    @Test
    public void openSubCategoriesScreenTest() {
        CategoryPage categoryPage = new CategoryPage(driver);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);

        categoryPage.openSubCategoryDropDown();
        categoryPage.clickSubCategory();

        Assert.assertEquals(subCategoryPage.getSubCategoryHeaderText(), "Subcategory");
    }


    @Test
    public void openCatalogPageTest() {
        clickHomePage();

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Online Store | My Store");
    }
}