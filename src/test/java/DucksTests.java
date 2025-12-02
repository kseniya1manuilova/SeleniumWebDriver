import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DucksTests {
    @Test
    public void openCategoriesScreenTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement categoriesLink = driver.findElement(By.cssSelector
                ("li.category-1:first-of-type > a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        categoriesLink.click();

        WebElement pageHeader = driver.findElement(By.cssSelector("h1.title"));

        Assert.assertEquals(pageHeader.getText(), "Rubber Ducks");

        driver.quit();
    }

    @Test
    public void openHomePageScreenTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement homePageLink = driver.findElement(By.cssSelector
                ("li.general-0 > a[href='https://litecart.stqa.ru/en/']"));
        homePageLink.click();

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Online Store | My Store");
        driver.quit();

    }

    @Test
    public void openSubCategoriesScreenTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement CategoriesLink = driver.findElement(By.cssSelector("li.category-1 > a[href*='rubber-ducks-c-1']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(CategoriesLink).perform();

        WebElement subCategoriesLink = driver.findElement(By.cssSelector("li.category-2 > a[href*='subcategory-c-2']"));
        subCategoriesLink.click();

        WebElement pageHeader = driver.findElement(By.cssSelector("h1.title"));

        Assert.assertEquals(pageHeader.getText(), "Subcategory");

        driver.quit();
    }
}