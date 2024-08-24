package manager;

import entry.UserEntry;

public interface UserManager {

    UserEntry getUser(String userName);

    UserEntry addUser(UserEntry userEntry);

    UserEntry updateUser(String userName, UserEntry userEntry);
}
