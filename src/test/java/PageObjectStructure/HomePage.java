package PageObjectStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class HomePage extends TestBase {


    public void openCategoriesPage(){
        driver.findElement(By.cssSelector
                ("li.general-0 > a[href='https://litecart.stqa.ru/en/']"));
    }
}
