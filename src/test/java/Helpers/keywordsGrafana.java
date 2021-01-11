package Helpers;

import Extensions.uiActions;

import static Utilities.base.grafanaLogin;

public class keywordsGrafana
{
        public static void enterFirstNameAndPassword(String username, String password)
    {
        uiActions.updateText(grafanaLogin.txt_userName, username);
        uiActions.updateText(grafanaLogin.txt_password, password);
    }
}
