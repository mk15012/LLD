package util;

import dto.User;
import dto.Expense;
import dto.ExpenseMetadata;
import entry.PercentSplit;
import entry.Split;
import enums.ExpenseType;

import java.util.List;

public class ExpenseUtil {

    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splitsList, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {
            case EXACT:
                return new Expense(amount, paidBy, splitsList, expenseMetadata);
            case EQUAL:
                int count = splitsList.size();
                double splitAmount = ((double) Math.round(amount * 100 / count)) / 100.0;
                for (Split split : splitsList) {
                    split.setAmount(splitAmount);
                }
                return new Expense(amount, paidBy, splitsList, expenseMetadata);
            case PERCENT:
                for (Split split : splitsList) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount * percentSplit.getPercent()) / 100.0);
                }
                return new Expense(amount, paidBy, splitsList, expenseMetadata);
            default:
                return null;
        }
    }
}
