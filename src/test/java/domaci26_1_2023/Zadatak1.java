package domaci26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class Zadatak1 {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Visit Paris");
        lista.add("Visit Prague");
        lista.add("Visit London");
        lista.add("Visit New York");
        lista.add("Visit Belgrade");
        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");
        Thread.sleep(1000);

        for (int i = 0; i < lista.size(); i++) {
            WebElement prvi =
            driver.findElement(By.className("new-todo"));
            prvi.sendKeys(lista.get(i));
            prvi.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

        }

        List<WebElement> brisanje = driver.findElements(By.className("destroy todo-button"));
        for (int i = 0; i < lista.size(); i++) {
            WebElement brisi = driver.findElement(By.className("destory todo-button"));
            brisi.click();
            Thread.sleep(1000);

        }
        driver.quit();



    }
}
