package domaci30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        driver.get("https://docs.katalon.com/");

        String tema = driver.findElement(By.xpath("/html")).getAttribute("data-theme");
        if (tema.equals("light")){
            System.out.println("Svetla tema.");
        }else {
            System.out.println("Tamna tema");
        }

        driver.findElement(By.xpath("//button[contains(@class, 'toggleButton')]")).click();
        Thread.sleep(2000);
        tema = driver.findElement(By.xpath("/html")).getAttribute("data-theme");
        if (tema.equals("dark")){
            System.out.println("Tamna tema");
        }else {
            System.out.println("Svetla tema");
        }

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("DocSearch-Modal"))));

        String provera = driver.findElement(By.xpath("//*[@class = 'DocSearch-Input']")).getAttribute("type");

        if (provera.equals("search")){
            System.out.println("Sve je pod kontrolom");
        }else {
            System.out.println("Tonemo");
        }
        Thread.sleep(1000);





        driver.quit();
    }
}
