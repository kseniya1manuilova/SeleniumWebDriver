package PageObjectStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = System.getProperty("browser", "chrome");

        driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> new ChromeDriver();

        };

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
