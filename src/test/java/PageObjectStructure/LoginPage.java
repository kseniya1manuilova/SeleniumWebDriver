package PageObjectStructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PageObjectStructure.Locators.getLocator;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

//    private By emailAddressLocator = By.cssSelector("input[name='email']");
//
//    private By passwordLocator = By.cssSelector("input[name='password']");
//
//    private By rememberMeCheckBoxLocator = By.cssSelector("input[name='remember_me']");
//
//    private By loginButtonLocator = By.cssSelector("button[name='login']");
//
//    private By noticeText = By.cssSelector("div.notice");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void loginFlowWithAllData(String email, String password) {
        driver.findElement(getLocator("LoginPage.EmailInput")).sendKeys(email);
        driver.findElement(getLocator("LoginPage.PasswordInput")).sendKeys(password);
        driver.findElement(getLocator("LoginPage.LoginButton")).click();
        driver.findElement(getLocator("LoginPage.NoticeText")).click();
    }

    public void loginFlowWithEmailDataOnly(String email) {
        driver.findElement(getLocator("LoginPage.EmailInput")).sendKeys(email);
        driver.findElement(getLocator("LoginPage.RememberMeCheckBoxInput")).click();
        driver.findElement(getLocator("LoginPage.LoginButton")).click();
    }

    public String getMessageText() {
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(
                "LoginPage.NoticeText")));
        return pageHeader.getText();
    }

    public boolean messageTextIsVisible() {
        return driver.findElement(getLocator("LoginPage.NoticeText")).isDisplayed();

    }
}
