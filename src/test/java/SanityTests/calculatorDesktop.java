package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.calcFlow;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class calculatorDesktop extends commonOps
{
    //Preconditions - Open WinAppDriver.exe window must(Path - C:\Program Files(*86)\Windows Application Driver\WinAppDriver.exe)
    @Test(description = "Test01: Verify Addition Command")
    @Description("Tests Description: Verify Addition Command in Calculator")
    public void test01_login()
    {
        calcFlow.calculateAddition();
        verifications.textInElement(calcMain.btn_calculatorResults,"6");
    }
}
