package PageObjectStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openHomePage() {
        driver.get("https://litecart.stqa.ru/en/");
    }

    public void clickHomePage() {
        driver.findElement(By.cssSelector
                ("li.general-0 > a[href='https://litecart.stqa.ru/en/']"));
    }
}
