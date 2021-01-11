package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

// Business Flow, That binds several steps to one action
public class calcFlow extends commonOps
{
    @Step("Calculate Addition")
    public static void calculateAddition()
    {
        uiActions.click(calcMain.btn_clear);
        uiActions.click(calcMain.btn_one);
        uiActions.click(calcMain.btn_plus);
        uiActions.click(calcMain.btn_five);
        uiActions.click(calcMain.btn_equals);

    }
}
