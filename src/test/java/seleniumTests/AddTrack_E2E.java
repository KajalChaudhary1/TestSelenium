package seleniumTests;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTrack_E2E {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver");
        //WebDriver driver =null;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sycamore-nonprod.kano.me/");

        purchaseDevice(driver);

    }

    public static void purchaseDevice(WebDriver driver) throws InterruptedException {
        System.out.println("Marketing Site opens");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        //driver.wait(5);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Set<String> s = driver.getWindowHandles();
        System.out.println("First window"+s);
        driver.switchTo().frame("frame-cart");
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[3]/button")).isDisplayed());
        driver.findElement(By.xpath("/html/body/div/div[3]/button")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[3]/button")).getText());

       // String childWindow = i1.next();
       //System.out.println("New window"+childWindow);

        //driver.switchTo().window(childWindow);
        //driver.close();

        String parent=driver.getWindowHandle();

        Set<String>s1=driver.getWindowHandles();

     // Now iterate using Iterator
        Iterator<String> i1= s1.iterator();
        System.out.println("value of iterator "+i1);
        System.out.println("next is "+i1.hasNext());
        while(i1.hasNext()) {

            String child_window = i1.next();
            System.out.println("New window " + child_window);
            driver.switchTo().window(child_window);

        }

        System.out.println(driver.findElement(By.xpath("//*[@id=\"checkout_email\"]")).isEnabled());
        driver.findElement(By.xpath("//*[@id=\"checkout_email\"]")).sendKeys("kajal.chaudhary@kano.me");

        WebElement firstName=driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_first_name\"]"));
        Actions build = new Actions(driver);
        build.moveToElement(firstName);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        build.perform();
        firstName.sendKeys("Kajal");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_last_name\"]")).sendKeys("Chaudhary");

        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_company\"]")).sendKeys("Kano Computin");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_address1\"]")).sendKeys("12.1 12.2");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_address2\"]")).sendKeys("Fashion Street");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_city\"]")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_zip\"]")).sendKeys("E1 6PX");
        driver.findElement(By.xpath("//*[@id=\"checkout_shipping_address_phone\"]")).sendKeys("55555555");
        //driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        System.out.println("Continue to shipping "+driver.findElement(By.xpath("//*[@id=\"continue_button\"]/span")).isEnabled());
        driver.findElement(By.xpath("//*[@id=\"continue_button\"]")).click();


    }

}

