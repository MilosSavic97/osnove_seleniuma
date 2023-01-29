package domaci26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> lista = driver.findElements(By.className("close"));
        List<WebElement> lista2 = driver.findElements(By.className("glyphicon glyphicon-certificate"));
        for (int i = 0; i < lista.size(); i++) {
            WebElement novi =
            driver.findElement(By.className("close"));
            novi.click();
            Thread.sleep(1000);

        }
        driver.quit();






        driver.quit();




    }
}
