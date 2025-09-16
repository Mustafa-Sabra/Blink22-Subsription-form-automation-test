package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubscriptionForm {


    private By FullnameField = By.xpath("//input[@id = 'fullname']");
    private By EmailField = By.xpath("//input[@id = 'email']");
    private By SubscripeButton = By.xpath("//button[@id = '_form_5_submit']");
    private By cookiesCancelField = By.xpath("//div[@class= 'cookiesDisplay']/span");
    private By errorMsgField = By.xpath("//div[@class = '_error-inner']");
    private By thanksMsgField = By.xpath("//div[@class='_form-thank-you']");

    private WebDriver driver;
    private WebDriverWait wait;

    public SubscriptionForm(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void cancelCookies()
    {
        driver.findElement(this.cookiesCancelField).click();
    }

    private void enterFullname(String name)
    {
        driver.findElement(this.FullnameField).sendKeys(name);
    }

    private void enterEmail(String email)
    {
        driver.findElement(this.EmailField).sendKeys(email);
    }

    private void submit()
    {
        driver.findElement(this.SubscripeButton).click();
    }


    public void subscripe(String  Fullname, String Email){
        this.cancelCookies();
        this.enterFullname(Fullname);
        this.enterEmail(Email);
        this.submit();

    }

    public void printPlaceholders(){
        String Name_placeholder = this.driver.findElement(this.FullnameField).getAttribute("placeholder");
        String Email_placeholder = this.driver.findElement(this.EmailField).getAttribute("placeholder") ;

        System.out.println(Name_placeholder);
        System.out.println(Email_placeholder);
    }

    public boolean isRequiredMsgDisplayed(){

        String errorMsg = driver.findElement((this.errorMsgField)).getText();
        if (errorMsg.equals("This field is required."))
            return true;
        else
            return false;

    }

    public boolean isDuplicateRequiredMsgDisplayed(){

        List<WebElement> errorMessages =  driver.findElements(this.errorMsgField);

        for(WebElement error: errorMessages)
        {
            if(!error.getText().equals("This field is required."))
                return false;
        }

        return (errorMessages.size() == 2);

    }

    public boolean isInvalidEmailMsgDisplayed(){

        List<WebElement> errorMsgList = driver.findElements((this.errorMsgField));

        int size = errorMsgList.size();

        if (errorMsgList.get(size-1).getText().equals("Enter a valid email address."))
            return true;
        else
            return false;

    }

    public boolean isThanksMsgDisplayed()
    {
        WebElement thanskMsg = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.thanksMsgField));

        System.out.println(thanskMsg.getText());

        return thanskMsg.isDisplayed();
    }


}
