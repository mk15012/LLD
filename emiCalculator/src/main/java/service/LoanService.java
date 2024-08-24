package service;

import entry.LoanEntry;

public interface LoanService {

    LoanEntry addLoan(LoanEntry loanEntry);

    LoanEntry getLoan(String userName);
}
