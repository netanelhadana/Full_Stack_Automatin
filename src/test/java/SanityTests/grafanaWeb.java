package SanityTests;

import Extensions.uiActions;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Extensions.verifications;

@Listeners(Utilities.listeners.class)
public class grafanaWeb extends commonOps
{
    // Open grafane server
    @Test(description = "Test01: Login to Grafana")
    @Description("Tests Description: Login to Grafana Web App")
    public void test01_login()
    {
        webFlows.login(getData("user"),getData("password"));
        verifications.textInElement(grafanaMain.txt_mainHeading,"Welcome to Grafana");
    }

    @Test(description = "Test02: Verify Default Users")
    @Description("Tests Description: Verifies the Number of Users in the Table (Should Be 1)")
    public void test02_verifyDefaultUsers()
    {
        uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,1);
    }

    @Test(description = "Test03: Add and Verify Users")
    @Description("Tests Description:  Add a New User and verify the Number of users is 2")
    public void test03_addAndVerifyUser()
    {
        uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
        webFlows.createUser("netanel","nat@nat.com","nati123","netanel");
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,2);
    }

    @Test(description = "Test04: Delete Last User and Verify Users")
    @Description("Tests Description: Delete Last Created User and Verify the Number of Users is 1")
    public void test04_deleteAndVerifyUsers()
    {
        uiActions.mouseHoverElements(grafanaLeftMenu.btn_serverAdmin,grafanaServerAdminMenuPage.link_users);
        webFlows.deleteLastUser();
        verifications.numberOfElements(grafanaServerAdminMainPage.rows,1 );
    }

    @Test(description = "Test05: Verify Avatar")
    @Description("Tests Description: Verify admin avatar logo")
    public void test05_verifyLogo()
    {
        verifications.visualElement(grafanaLeftMenu.imageAvatar, "grafanaAvatar_version 1.0" );
    }
}
