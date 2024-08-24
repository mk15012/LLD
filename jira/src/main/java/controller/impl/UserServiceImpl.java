package controller.impl;

import controller.UserService;
import lombok.AllArgsConstructor;
import manager.UserManager;


@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserManager userManager;

}
