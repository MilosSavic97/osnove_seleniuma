package domaci24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;

public class Zadatak1 {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" );
        Thread.sleep(10000);
       // Actions tastatura = new Actions(driver);
        //tastatura.sendKeys("Admin");

       
       WebElement userName = driver.findElement(By.name("username"));

        userName.click();
        userName.sendKeys("Admin");
        Thread.sleep(1000);


        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class= 'oxd-form']/div[3]/button")).click();
        Thread.sleep(2000);
        driver.quit();

    }

    private static ChronoLocalDate WebDriverWait(WebDriver driver, int i) {
        return null;
    }
}
