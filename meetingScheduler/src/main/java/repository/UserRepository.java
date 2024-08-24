package repository;

import dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    static Map<String, User> userMap;
    static List<User> userList;

    public UserRepository() {
        userMap = new HashMap<>();
        userList = new ArrayList<>();
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }

    public static List<User> getUserList() {
        return userList;
    }
}
