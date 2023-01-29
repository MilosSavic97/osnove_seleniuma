package domaci27_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
    public boolean elementExist(WebDriver driver, By by) {
        boolean elementExist = true;
        try {
            WebElement div = driver.findElement(by);
        } catch (NoSuchElementException error) {
            elementExist = false;
        }
        return elementExist;
    }
}
