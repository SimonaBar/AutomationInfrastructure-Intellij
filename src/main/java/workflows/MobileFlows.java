package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
/**
 * MobileFlows contains business flows for the mobile application,
 * such as adding a new expense in the Expense Tracker app.
 * Uses MobileActions to perform UI interactions like typing text and tapping elements.
 */
public class MobileFlows extends CommonOps {
    /**
     * Fills out and submits a new expense form in the mobile Expense Tracker app.
     * Steps performed:
     * - Types the expense name and amount.
     * - Selects a date for the expense.
     * - Chooses a category.
     * - Taps to add/save the expense.
     */

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
