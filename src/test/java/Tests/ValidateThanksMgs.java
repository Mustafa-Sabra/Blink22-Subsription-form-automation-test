package Tests;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateThanksMgs extends TestBase {

@Test
    public void validateThanksMsg()
{
    subscriptionForm.subscripe("Mustafa", "mo@gmail.com");
    Assert.assertTrue(subscriptionForm.isThanksMsgDisplayed());
}

}
