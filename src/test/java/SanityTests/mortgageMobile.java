package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class mortgageMobile extends commonOps
{
    //Preconditions - Device: Click several times on MIUI Version will open Developer options -> Marked USB debugging -> On the popup marked the checkbox and click on OK
    //Open Appium Studio -> Add your device to the list -> Go to application list and select your app ->
    @Test(description = "Test01: Verify Mortgage")
    @Description("Tests Description: Fill in mortgage fields and calculate repayments")
    public void test01_verifyRepayment()
    {
        mobileFlows.calculate("1000", "3", "4");
        verifications.textInElement(mortgageMain.txt_repayment,"£50.03");
    }
}
