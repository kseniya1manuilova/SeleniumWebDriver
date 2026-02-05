package PageObjectStructure;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static Properties props;

    static {
        props = new Properties();
        try (InputStream is = Locators.class.getResourceAsStream("/locators.properties")) {
            if (is == null) {
                throw new RuntimeException("locators nor found");
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static By getLocator(String locatorName) {
        String value = props.getProperty(locatorName);

        if (value == null) {
            throw new RuntimeException("Locator not found: " + locatorName);
        }

        String[] result = value.split("=", 2);
        if (result.length != 2) {
            throw new RuntimeException("Invalid locator format for: " + locatorName);
        }

        LocatorType locatorType = LocatorType.valueOf(result[0].toLowerCase());
        String selector = result[1];

        switch (locatorType) {
            case name:
                return By.name(selector);
            case css:
                return By.cssSelector(selector);
            case xpath:
                return By.xpath(selector);
            default:
                throw new RuntimeException("Unsupported locator type: " + locatorName);
        }
    }
}
