import dto.User;
import entry.EqualSplit;
import entry.ExactSplit;
import entry.PercentSplit;
import entry.Split;
import enums.ExpenseType;
import service.ExpenseService;
import service.InMemoryService;
import service.ShowService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseApplication {

    public static void main(String[] args) {

        InMemoryService inMemoryService = new InMemoryService();
        ExpenseService expenseService = new ExpenseService();
        UserService userService = new UserService();
        ShowService showService = new ShowService();

        userService.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        userService.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        userService.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        userService.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        showService.showBalances();
                    } else {
                        showService.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(userService.getUser(commands[4 + i])));
                            }
                            expenseService.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(userService.getUser(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseService.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit(userService.getUser(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseService.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
                            break;
                    }
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
            }
        }
    }
}