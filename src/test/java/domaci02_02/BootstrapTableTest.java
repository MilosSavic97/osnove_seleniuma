package domaci02_02;


import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String firstName = "Milos";
    private String lastName = "Savic";
    private String middleName= "Dragan";
    private String baseUrl = "https://s.bootsnipp.com";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

    }

    @BeforeMethod
    public void beforeMethodSetup(){
        driver.get(baseUrl);
    }

    @Test
    @Description("Tc-1 Verify that rows can be edited")
    public void editRows(){
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "Not expected title");
        driver.findElement(By.xpath("//tr[@id= 'd1']/td[5]/button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-dialog"))));
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys(firstName);

        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys(lastName);

        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys(middleName);

        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("modal-dialog"))));

        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id= 'd1']/td[2]")).getText().equals("Milos"), "Wrong name");
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id= 'd1']/td[3]")).getText().equals("Savic"), "Wrong last name");
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id= 'd1']/td[4]")).getText().equals("Dragan"), "Wrong middle name");

    }

    @Test
    @Description("Deleting rows")
    public void deleteRow(){
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "Not expected title");
        driver.findElement(By.xpath("//tr[@id= 'd1']/td[6]/button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("delete"))));
        driver.findElement(By.xpath("//button[@id= 'del']")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("delete"))));

        Assert.assertTrue(driver.findElements(By.xpath("//tr[@id='d1']/td")).size()<1, "Row is not deleted");

    }

    @Test
    @Description("Tc-3 taking screenshot")
    public void takeScreenshot(){
        driver.get(baseUrl+"/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com", "Not expected title");
        TakesScreenshot ts=(TakesScreenshot)driver;
        try {
            new Helper()
                    .takeScreenshot(driver,
                            "screenshots/slike.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterclass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
