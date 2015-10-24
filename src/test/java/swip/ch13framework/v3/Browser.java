package swip.ch13framework.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Browser {
    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public Element findElement(By by) {
        return new Element(driver.findElement(by));
    }
}
