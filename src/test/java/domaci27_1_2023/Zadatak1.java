package domaci27_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

      List<String> lista = new ArrayList<String>();
      lista.add("primary");
      lista.add("secondary");
      lista.add("succes");
      lista.add("danger");
      lista.add("warning");
      lista.add("info");
      lista.add("light");
      lista.add("dark");
      Helper helper = new Helper();

        for (int i = 0; i < lista.size(); i++) {
            driver.findElement(By.id("basic-" + lista.get(i)+ "-trigger")).click();
            Thread.sleep(2000);
            helper.elementExist(driver, By.className("toast"+lista.get(i)+""));
        }




       // List<WebElement> lista = driver.findElements(By.xpath("//div[1][@class = 'container text-center']/button"));

        //for (int i = 0; i < lista.size()-1; i++) {
          //  WebElement novi = lista.get(i).findElement(By.className("//div[1][@class = 'container text-center']/button["+(i+1)+"]"));
           // novi.click();
           // Thread.sleep(2000);
       // }


        Thread.sleep(2000);
        driver.quit();
    }
}
