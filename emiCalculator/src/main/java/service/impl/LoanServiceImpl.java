package service.impl;

import entry.LoanEntry;
import manager.LoanManager;
import manager.impl.LoanManagerImpl;
import service.LoanService;

public class LoanServiceImpl implements LoanService {

    private static LoanManager loanManager = new LoanManagerImpl();

    @Override
    public LoanEntry addLoan(LoanEntry loanEntry) {
        return loanManager.addLoan(loanEntry);
    }

    @Override
    public LoanEntry getLoan(String userName) {
        return loanManager.getLoan(userName);
    }
}
