package service;

import dto.Expense;
import dto.ExpenseMetadata;
import entry.Split;
import enums.ExpenseType;
import repository.ExpenseRepository;
import repository.UserRepository;
import util.ExpenseUtil;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {

        Expense expense = ExpenseUtil.createExpense(expenseType, amount, UserRepository.getUserMap().get(paidBy), splits, expenseMetadata);
        ExpenseRepository.add(expense);
        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = UserRepository.getBalanceSheet().get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = UserRepository.getBalanceSheet().get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

}
