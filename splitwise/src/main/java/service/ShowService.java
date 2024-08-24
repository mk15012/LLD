package service;

import constants.Errors;
import repository.UserRepository;

import java.util.Map;

public class ShowService {

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : UserRepository.getBalanceSheet().get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println(Errors.NO_BALANCE);
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : UserRepository.getBalanceSheet().entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println(Errors.NO_BALANCE);
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = UserRepository.getUserMap().get(user1).getName();
        String user2Name = UserRepository.getUserMap().get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }

}
