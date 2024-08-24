package repository;

import dto.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    static List<Expense> expenses;

    public ExpenseRepository() {
        expenses = new ArrayList<>();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public static void add(Expense expense) {
        expenses.add(expense);
    }

}
