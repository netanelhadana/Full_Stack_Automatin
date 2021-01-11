package Utilities;

import org.openqa.selenium.support.PageFactory;

// Class that manage all the pages and heiress from base
public class managePages extends base
{
    // Initialization method
    public static void init()
    {
        grafanaLogin = PageFactory.initElements(driver,PageObjects.Grafana.loginPage.class);
        grafanaMain = PageFactory.initElements(driver,PageObjects.Grafana.mainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver,PageObjects.Grafana.leftMenuPage.class);
        grafanaServerAdminMenuPage = PageFactory.initElements(driver,PageObjects.Grafana.serverAdminMenuPage.class);
        grafanaServerAdminMainPage = PageFactory.initElements(driver,PageObjects.Grafana.serverAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver,PageObjects.Grafana.addNewUserPage.class);
        grafanaAdminMenuPage = PageFactory.initElements(driver,PageObjects.Grafana.adminMenuPage.class);
        mortgageMain =  PageFactory.initElements(driver,PageObjects.Mortgage.mainPage.class);
        electronMain =  PageFactory.initElements(driver,PageObjects.ElectronDemo.mainPage.class);
        calcMain =  PageFactory.initElements(driver,PageObjects.calculator.mainPage.class);
    }
}
