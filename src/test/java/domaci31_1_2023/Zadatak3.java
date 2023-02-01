package domaci31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        driver.get("https://itbootcamp.rs/");
        //new Actions(driver)
               // .scrollToElement(driver.findElement(By.className("vc_row wpb_row vc_row-fluid slider_bkgd")))
              //  .perform();

        List<WebElement> lista = driver.findElements(By.xpath("//*[contains(@class,'owl-item')]/div/img"));
        helper helper = new helper();
        for (int i = 0; i < lista.size(); i++) {

            if (helper.response(lista.get(i).getAttribute("src")) >=200 &&
                    helper.response(lista.get(i).getAttribute("src")) < 300 ) {
                    helper.downloadFile((lista.get(i).getAttribute("src")), "itBootcamp_slider/img"+i+".jpg");
            }

        }


    }
}
