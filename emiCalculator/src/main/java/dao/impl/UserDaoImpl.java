package dao.impl;

import dao.UserDao;
import entry.UserEntry;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserDaoImpl implements UserDao {

    static Map<String, UserEntry> userEntryMap;

    public UserDaoImpl() {
        userEntryMap = new HashMap<>();
    }

    @Override
    public UserEntry getUser(String userName) {
        return userEntryMap.get(userName);
    }

    @Override
    public UserEntry addUser(UserEntry userEntry) {
        if(userEntryMap.containsKey(userEntry.getUserName())) {
            System.out.println("User already exists");
            return userEntry;
        }
        userEntryMap.put(userEntry.getUserName(), userEntry);
        System.out.println("User " +  userEntry.getUserName() + " added successfuly");
        return userEntry;
    }

    @Override
    public UserEntry updateUser(String userName, UserEntry userEntry) {
        if(!userEntryMap.containsKey(userEntry.getUserName())) {
            System.out.println("No such user exists");
            return null;
        }

        userEntryMap.put(userEntry.getUserName(), userEntry);
        System.out.println("User " +  userEntry.getUserName() + " updated successfuly");
        return userEntry;
    }

}
