package WorkFlows;

import Extensions.apiActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

// Business Flow, That binds several steps to one action
public class electronFlows extends commonOps
{
    @Step("Get Screen Info (Resolution)")
    public static void getScreenInfo()
    {
        uiActions.click(electronMain.btn_window);
        uiActions.click(electronMain.btn_information);
        uiActions.click(electronMain.btn_demo_toggle);
        uiActions.click(electronMain.btn_demo_toggle);
        uiActions.click(electronMain.btn_screen_info);
    }
}
