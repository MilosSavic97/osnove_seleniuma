package domaci24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadataka2 {
    public static void main(String[] args)throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> toDO = new ArrayList<String>();

        toDO.add("Visit Paris");
        toDO.add("Visit Prague");
        toDO.add("Visit London");
        toDO.add("Visit New York");
        toDO.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < toDO.size(); i++) {
            WebElement todo =
            driver.findElement(By.xpath("//*[@placeholder= 'What needs to be done?']"));
            todo.sendKeys(toDO.get(i));
            todo.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

        }
        driver.quit();

    }
}
