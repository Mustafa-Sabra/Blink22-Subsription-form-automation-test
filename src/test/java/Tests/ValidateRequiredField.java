package Tests;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateRequiredField extends TestBase {

    @Test
    public void validateEmptyFullname()
    {
        subscriptionForm.subscripe("", "Mo@gmail.com");
        Assert.assertTrue(subscriptionForm.isRequiredMsgDisplayed());
    }

    @Test
    public void validateEmptyEmail()
    {
        subscriptionForm.subscripe("Mohamed Ahmed", "");
        Assert.assertTrue(subscriptionForm.isRequiredMsgDisplayed());
    }

    @Test
    public void validateEmptyFullnameAndEmail()
    {
        subscriptionForm.subscripe("", "");
        Assert.assertTrue(subscriptionForm.isDuplicateRequiredMsgDisplayed());
    }





}
