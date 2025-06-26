package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step(" Calculate Addition 1 + 2 ")
    public static void calculateAddition(){
        UIActions.click1(calcAppMain.btn_clear);
        UIActions.click1(calcAppMain.btn_one);
        UIActions.click1(calcAppMain.btn_Plus);
        UIActions.click1(calcAppMain.btn_Two);
        UIActions.click1(calcAppMain.btn_Equals);





    }


}
