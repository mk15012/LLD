package service;

import dto.User;
import repository.UserRepository;

import java.util.Objects;

public class UserService {

    public void addUser(String id, String name, String email) {
        User user = new User(id, name, email);
        UserRepository.getUserList().add(user);
        UserRepository.getUserMap().put(id, user);
    }

    public User getUser(String id) {
        User user = UserRepository.getUserMap().get(id);
        if (Objects.isNull(user)) {
            System.out.println("Invalid User");
        }
        return user;
    }



}
