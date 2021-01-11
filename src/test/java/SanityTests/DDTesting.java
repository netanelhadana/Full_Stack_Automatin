package SanityTests;

import Extensions.excelActions;
import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Listeners(Utilities.listeners.class)
public class DDTesting extends commonOps
{
    @Test(dataProvider = "loginData")
    @Description("Login test data: Connect with different users")
    public void testDD(String username, String password, String exp) throws InterruptedException
    {
        String exp_title = "Home - Grafana";
        uiActions.updateText(grafanaLogin.txt_userName, username);
        uiActions.updateText(grafanaLogin.txt_password, password);
        uiActions.click(grafanaLogin.btn_login);
            if (exp.equals("Valid"))
            {
                uiActions.click(grafanaLogin.btn_Skip);
                String actT = driver.getTitle();
                Thread.sleep(3000);
                System.out.println(actT);
                if (exp_title.equals(actT))
                {
                    uiActions.mouseHoverElements(grafanaLeftMenu.btn_admin,grafanaAdminMenuPage.btn_logout);
                    assertTrue(true);
                }
                else
                {
                    assertTrue(false);
                }
            }
            else if (exp.equals("Invalid"))
            {
                if (exp_title.equals(driver.getTitle()))
                {
                    uiActions.click(grafanaLeftMenu.btn_serverAdmin);
                    uiActions.click(grafanaAdminMenuPage.btn_logout);
//                    uiActions.mouseHoverElements(grafanaLeftMenu.btn_admin,grafanaAdminMenuPage.btn_logout);
                    assertTrue(false);
                }
                else
                {
                    assertTrue(true);
                }
            }
        }
    }
