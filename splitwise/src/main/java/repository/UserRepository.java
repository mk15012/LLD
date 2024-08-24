package repository;

import dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    static Map<String, User> userMap;
    static Map<String, Map<String, Double>> balanceSheet;

    public UserRepository() {
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public static void addUser(String userId, User user) {
        userMap.put(userId, user);
    }

    public static void addBalanceSheet(String userId, Map<String, Double> balance) {
        balanceSheet.put(userId, balance);
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }

    public static Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }
}
