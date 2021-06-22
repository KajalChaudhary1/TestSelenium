package seleniumTests;
import java.util.List;
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
        driver.get("https://staging-stemplatform.netlify.app/");

        //driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

        //driver.quit();

    }

}

