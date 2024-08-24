package service.impl;

import entry.UserEntry;
import manager.UserManager;
import manager.impl.UserManagerImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

    static UserManager userManager = new UserManagerImpl();

    @Override
    public UserEntry getUser(String userName) {
        return userManager.getUser(userName);
    }

    @Override
    public UserEntry addUser(UserEntry userEntry) {
        return userManager.addUser(userEntry);
    }

    @Override
    public UserEntry updateUser(String userName, UserEntry userEntry) {
        return userManager.updateUser(userName, userEntry);
    }
}
