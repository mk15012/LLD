package service;

import entry.UserEntry;

public interface UserService {

    UserEntry getUser(String userName);

    UserEntry addUser(UserEntry userEntry);

    UserEntry updateUser(String userName, UserEntry userEntry);
}
