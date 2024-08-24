package dao;

import entity.User;

public interface UserDao {

    User getUser(String email) throws Exception ;

    User createUser(String name, String email) throws Exception ;

    User updateUser(String userId, User user) throws Exception ;

    boolean deleteUser(String userId) throws Exception ;

}
