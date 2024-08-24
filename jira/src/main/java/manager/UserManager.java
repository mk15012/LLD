package manager;

import entity.Task;
import entity.User;

import java.util.List;

public interface UserManager {

    User getUser(String userId) throws Exception;

    User createUser(String name, String email) throws Exception;

    User updateUser(String userId, User user) throws Exception;

    boolean deleteUser(String userId) throws Exception;

    List<Task> getUserWorkload(String email) throws Exception;

}
