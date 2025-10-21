import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MySeleniumTest {

    @Test
    public void firstSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement linksContainer = driver.findElement(By.id("content"));
        List<WebElement> links = linksContainer.findElements(By.tagName("a"));
        Assert.assertEquals(links.size(), 44);
        links.get(9).click();
        driver.close();
    }
}
