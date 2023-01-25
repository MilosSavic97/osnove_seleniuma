package domaci24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'art-control art-control-playAndPause']/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-volume hint--rounded hint--top']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-screenshot']")).click();
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-pip']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-pip']")).click();
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-fullscreenWebOn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class = 'art-icon art-icon-fullscreenWebOff']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
