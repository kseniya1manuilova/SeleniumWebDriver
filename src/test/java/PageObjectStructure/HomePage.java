package PageObjectStructure;

import org.openqa.selenium.By;

public class HomePage extends TestBase {


    public void openCategoriesPage() {
        driver.findElement(By.cssSelector
                ("li.general-0 > a[href='https://litecart.stqa.ru/en/']"));
    }
}
