package domaci31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

        driver.get("https://itbootcamp.rs/");

        List<WebElement> lista = driver.findElements(By.xpath("//*[contains(@id, 'menu-main-menu')]/li[position()>1 and position()<6]"));

        for (int i = 0; i < lista.size() ; i++) {
            new Actions(driver)
                    .moveToElement(lista.get(i))
                    .perform();
        wait.until(ExpectedConditions.visibilityOf(lista.get(i)));
        Thread.sleep(1000);
        }

        driver.quit();


    }
}
