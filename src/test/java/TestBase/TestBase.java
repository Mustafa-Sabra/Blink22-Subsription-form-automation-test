package TestBase;

import Pages.SubscriptionForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SubscriptionForm subscriptionForm;

    @BeforeMethod
    public void beforeMethod(){
        this.driver = new ChromeDriver();

        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));

        driver.get("https://www.blink22.com/blog/clutch-recognizes-blink22-among-egypts-app-developers-for-2021");
        driver.manage().window().maximize();

        subscriptionForm = new SubscriptionForm(this.driver);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();

    }




}
