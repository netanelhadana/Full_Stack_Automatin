package SanityTests;

import Extensions.excelActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class grafanaWebDB extends commonOps
{
    @Test(description = "Test01: Login to Grafana Web application with DB")
    @Description("Tests Description: Login to Grafana Web Application with DB")
    public void test01_login()
    {

        webFlows.loginDB();
        verifications.textInElement(grafanaMain.txt_mainHeading,"Welcome to Grafana");
    }
}
