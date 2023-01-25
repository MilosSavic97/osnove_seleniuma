package domaci24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//*[@type='button']")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("name")).sendKeys("Milos");
            driver.findElement(By.name("department")).sendKeys("QA");
            driver.findElement(By.name("phone")).sendKeys("066 4040 0440");
            driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr[last()]/td[last()]/a[@class='add']/i")).click();
            Thread.sleep(500);

        }
        driver.quit();


    }
}
