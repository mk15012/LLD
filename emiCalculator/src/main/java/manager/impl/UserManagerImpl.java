package manager.impl;

import dao.UserDao;
import entry.UserEntry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import manager.UserManager;

@AllArgsConstructor
@NoArgsConstructor
public class UserManagerImpl implements UserManager {

    private UserDao userDao;

    @Override
    public UserEntry getUser(String userName) {
        return userDao.getUser(userName);
    }

    @Override
    public UserEntry addUser(UserEntry userEntry) {
        return userDao.addUser(userEntry);
    }

    @Override
    public UserEntry updateUser(String userName, UserEntry userEntry) {
        return userDao.updateUser(userName, userEntry);
    }
}
