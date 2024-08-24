package dao.impl;

import dao.UserDao;
import entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class UserDaoImpl implements UserDao {

    private final Map<String, User> userMap;
    private final Map<String, String> emailToUserIdMap;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        this.emailToUserIdMap = new HashMap<>();
    }

    @Override
    public User getUser(String email) throws Exception {
        validateUser(email);
        return userMap.get(getUserId(email));
    }

    @Override
    public User createUser(String name, String email) throws Exception {
        User user = new User(name, email);
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        userMap.put(userId, user);
        emailToUserIdMap.put(email, userId);
        return user;

    }

    @Override
    public User updateUser(String email, User user) throws Exception {
        validateUser(email);
        return userMap.put(email, user);
    }


    @Override
    public boolean deleteUser(String email) throws Exception {
        validateUser(email);
        userMap.remove(email);
        return true;
    }

    private void validateUser(String email) throws Exception {
        if (!userMap.containsKey(getUserId(email))) {
            throw new Exception("Invalid user");
        }
    }

    private String getUserId(String email) {
        return emailToUserIdMap.get(email);
    }
}
