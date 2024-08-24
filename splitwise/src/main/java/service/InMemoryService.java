package service;

import repository.ExpenseRepository;
import repository.UserRepository;

public class InMemoryService {
    ExpenseRepository expenseRepository = new ExpenseRepository();
    UserRepository userRepository = new UserRepository();
}
