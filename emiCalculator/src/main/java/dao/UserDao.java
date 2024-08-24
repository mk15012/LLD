package dao;

import entry.UserEntry;

public interface UserDao {

    UserEntry addUser(UserEntry userEntry);

    UserEntry updateUser(String userName, UserEntry userEntry);

    UserEntry getUser(String userName);


}
