package dao;

import entry.LoanEntry;

public interface LoanDao {

    LoanEntry addLoan(LoanEntry loanEntry);

    LoanEntry getLoan(String userName);

}
