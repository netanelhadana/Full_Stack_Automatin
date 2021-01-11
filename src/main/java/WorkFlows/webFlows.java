package WorkFlows;

import Extensions.dbActions;
import Extensions.excelActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

// Business Flow, That binds several steps to one action
public class webFlows extends commonOps
{
    @Step("Login Grafana Flow")
    public static void login(String user, String pass)
    {
        uiActions.updateText(grafanaLogin.txt_userName, user);
        uiActions.updateText(grafanaLogin.txt_password, pass);
        uiActions.click(grafanaLogin.btn_login);
        uiActions.click(grafanaLogin.btn_Skip);
    }

    @Step("Login Grafana Flow with DB Credentials")
    public static void loginDB()
    {
//        dbActions.getCredentials("SELECT user_name, password FROM Credentials WHERE id='3'");
        List<String> cred = dbActions.getCredentials("SELECT user_name, password FROM Credentials WHERE id='3'");
        uiActions.updateText(grafanaLogin.txt_userName, cred.get(0));
        uiActions.updateText(grafanaLogin.txt_password, cred.get(1));
        uiActions.click(grafanaLogin.btn_login);
        uiActions.click(grafanaLogin.btn_Skip);
    }

    @Step("Create a New User")
    public static void createUser(String name, String email, String userName, String password)
    {
        uiActions.click(grafanaServerAdminMainPage.btn_newUser);
        uiActions.updateText(grafanaAddNewUser.txt_name,name);
        uiActions.updateText(grafanaAddNewUser.txt_email,email);
        uiActions.updateText(grafanaAddNewUser.txt_userName,userName);
        uiActions.updateText(grafanaAddNewUser.txt_password,password);
        uiActions.click(grafanaAddNewUser.btn_create);
    }

    @Step("Delete Last User From Users Table ")
    public static void deleteLastUser()
    {
        uiActions.click(grafanaServerAdminMainPage.rows.get(grafanaServerAdminMainPage.rows.size()-1));
        uiActions.click(grafanaAddNewUser.btn_deleteUser);
        uiActions.click(grafanaAddNewUser.btn_confirmDelete);

    }

    @Step("Login Grafana Flow")
    public static void logout(String user, String pass)
    {
        uiActions.updateText(grafanaLogin.txt_userName, user);
        uiActions.updateText(grafanaLogin.txt_password, pass);
        uiActions.click(grafanaLogin.btn_login);
        uiActions.click(grafanaLogin.btn_Skip);
    }

}
