package manager.impl;

import dao.TaskDao;
import dao.UserDao;
import entity.Task;
import entity.User;
import lombok.AllArgsConstructor;
import manager.UserManager;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
public class UserManagerImpl implements UserManager {

    
    UserDao userDao;

    
    TaskDao taskDao;

    @Override
    public User getUser(String userId) throws Exception {
        return userDao.getUser(userId);
    }

    @Override
    public User createUser(String name, String email) throws Exception {
        return userDao.createUser(name, email);
    }

    @Override
    public User updateUser(String userId, User user) throws Exception {
        return userDao.updateUser(userId, user);
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        userDao.deleteUser(userId);
        return true;
    }

    @Override
    public List<Task> getUserWorkload(String email) throws Exception {
        User user = userDao.getUser(email);
        if (Objects.isNull(user)) {
            throw new Exception("No such user exists");
        }

        return taskDao.getAllTasksAssignedToUser(user.getUserId());
    }

}
