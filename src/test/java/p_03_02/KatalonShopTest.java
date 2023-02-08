package p_03_02;

import jdk.jfr.Description;
import net.bytebuddy.build.Plugin;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.CartPage;
import pages.NavPage;
import pages.ProductPage;


import java.time.Duration;

public class KatalonShopTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";
    private CartPage cartPage;
    private ProductPage productPage;
    private NavPage navPage;




    @BeforeClass

        public void beforeClass(){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
            cartPage = new CartPage(driver, wait);
            productPage = new ProductPage(driver, wait);
            navPage = new NavPage(driver, wait);
    }



    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")
    public  void test1() throws InterruptedException {
        driver.get(baseUrl+ "/product/flying-ninja/");
        driver.findElement(By.xpath("//*[@class='quantity']/input")).clear();
        driver.findElement(By.xpath("//*[@class='quantity']/input")).sendKeys("3");
        driver.findElement(By.name("add-to-cart")).click();

        WebElement message = driver.findElement(By.className("woocommerce-message"));

        Assert.assertTrue(message.getText().contains("Flying Ninja"),
                "Message doesn't contain right message");

        driver.findElement(By.className("woocommerce-message"))
                .findElement(By.tagName("a")).click();

        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");

        int cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");

        }

        @Test (priority = 20)
        @Description("Removing products form cart")
        public void removingProductsFromCart(){

            driver.get(baseUrl);
            driver.findElement(By.xpath("//li[@class= 'page_item page-item-8']/a")).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));

            int cartElements = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
            Assert.assertEquals(cartElements,1,"There are no products in the cart");


        }
    @Test (priority = 30)
    @Description("Verify error is displayed when username is missing")
    public void errorWhenUsernameMissing() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id= 'primary-menu']/ul/li[3]")).click();
        driver.findElement(By.xpath("//p[@class= 'form-row']/button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'woocommerce-error']/li")).getText().equals("Error: Username is required."));
    }
    @Test (priority = 40)
    @Description("Verify error is displayed when password is wrong")
    public void errorWhenPasswordMissing() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id= 'primary-menu']/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id= 'username']")).sendKeys("customer");
        driver.findElement(By.xpath("//p[@class= 'form-row']/button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'woocommerce-error']/li")).getText().equals("ERROR: The password field is empty."));
    }
    @Test (priority = 50)
    @Description("Verify error is displayed when password is missing")
    public void errorWhenPasswordWrong() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id= 'primary-menu']/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id= 'username']")).sendKeys("customer");
        driver.findElement(By.xpath("//*[@id= 'password']")).sendKeys("invalid");
        driver.findElement(By.xpath("//p[@class= 'form-row']/button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'woocommerce-error']/li")).getText().equals("ERROR: The password you entered for the username customer is incorrect. Lost your password?"), "Didnt appear");

    }
    @AfterClass
        public void afterClass(){
            driver.quit();
        }


}
