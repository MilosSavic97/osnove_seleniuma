package domaci26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://geodata.solutions/");

        WebElement select1 = driver.findElement(By.id("countryId"));
        Select selectCountry = new Select(select1);
        selectCountry.selectByVisibleText("Argentina");

        Thread.sleep(2000);

        WebElement select2 = driver.findElement(By.id("stateId"));
        Select selectState = new Select(select2);
        selectState.selectByVisibleText("Buenos Aires");

        Thread.sleep(2000);

        WebElement select3 = driver.findElement(By.id("cityId"));
        Select selectCity = new Select(select3);
        selectCity.selectByVisibleText("Azul");

        Thread.sleep(1000);

        driver.quit();





    }
}
