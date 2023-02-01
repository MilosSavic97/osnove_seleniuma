package domaci30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        Select selekt = new Select(driver.findElement(By.id("delay-select")));
        selekt.selectByValue("2000");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        Thread.sleep(1000);

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("sentinel"))).perform();
        Thread.sleep(1000);

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        Thread.sleep(1000);

        driver.findElement(By.id("infinite-scroll-button")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("item"), 8));

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id = 'infinite-scroll-button']/span[1]"), "Loading more items..."));


        driver.quit();



    }

}
