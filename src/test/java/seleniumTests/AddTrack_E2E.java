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
        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div")).getText());
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Set<String> s = driver.getWindowHandles();
        System.out.println(s);
        driver.switchTo().frame("frame-cart");
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[3]/button")).isDisplayed());
        driver.findElement(By.xpath("/html/body/div/div[3]/button")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[3]/button")).getText());
        //Iterator<String> i1 = s.iterator();
        //System.out.println(i1.hasNext());
        //String childWindow = i1.next();
        //driver.switchTo().window(childWindow);
        //driver.close();
    }

}

