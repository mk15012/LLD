package service;

import dto.User;
import repository.UserRepository;

import java.util.HashMap;

public class UserService {

    public void addUser(User user) {
        UserRepository.addUser(user.getId(), user);
        UserRepository.addBalanceSheet(user.getId(), new HashMap<>());
    }

    public User getUser(String userId) {
        return UserRepository.getUserMap().get(userId);


    }

}
