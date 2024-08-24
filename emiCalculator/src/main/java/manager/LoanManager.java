package manager;

import entry.LoanEntry;

public interface LoanManager {

    LoanEntry addLoan(LoanEntry loanEntry);

    LoanEntry getLoan(String userName);

}
