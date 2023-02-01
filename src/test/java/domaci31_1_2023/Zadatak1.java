package domaci31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.findElement(By.xpath("//*[@class = 'edit-image']")).click();
        driver.findElement(By.id("image-option-remove")).click();


        //driver.findElement(By.className("sc-hHTYSt bhBnqr")).click();

        driver.findElement(By.className("edit-image")).click();
        driver.findElement(By.id("imageUpload")).
                sendKeys(new File("test_data/gume1.jpg").getAbsolutePath());
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//*[@id = 'image-crop-done-button']/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();
        driver.findElement(By.id("imageUpload")).
                sendKeys(new File("test_data/gume2.jpg").getAbsolutePath());
        driver.findElement(By.id("image-option-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id = 'image-crop-done-button']/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();
        driver.findElement(By.id("imageUpload")).
                sendKeys(new File("test_data/kola2java.jpg").getAbsolutePath());
        driver.findElement(By.id("image-option-0")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'image-crop-done-button']/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("edit-image")).click();
        driver.findElement(By.id("imageUpload")).
                sendKeys(new File("test_data/kola2java.jpg").getAbsolutePath());
        driver.findElement(By.id("image-option-0")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'image-crop-done-button']/button")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("textareaID")).sendKeys("gume");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();



        Thread.sleep(5000);
        driver.quit();



    }
}
