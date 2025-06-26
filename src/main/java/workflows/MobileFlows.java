package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill The Expense Tracker")
    public static void expenseTracker(String expenseName,String amount,String date,String category){
        MobileActions.updateText(expenseMain.getExpenseNameElement(),expenseName);
        MobileActions.updateText(expenseMain.getExpenceAmountElement(),amount);
        MobileActions.tap(expenseMain.getExpenseDatElement());
        MobileActions.tap(expenseMain.getDatElement());
        MobileActions.tap(expenseMain.getBtnExpenseDatElement());
        MobileActions.tap(expenseMain.getExpensCategoryElement());
        MobileActions.tap(expenseMain.AddExpenseElement());
        MobileActions.tap(expenseMain.getAddExpenseElement());

    }


}
