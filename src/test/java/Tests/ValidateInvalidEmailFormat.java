package Tests;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateInvalidEmailFormat extends TestBase {

    @Test
    public void validateInvalidEmailFormate()
    {
        subscriptionForm.subscripe("", "dummy");
        Assert.assertTrue(subscriptionForm.isInvalidEmailMsgDisplayed());
    }

}
