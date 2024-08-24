package manager.impl;

import dao.LoanDao;
import entry.LoanEntry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import manager.LoanManager;
import strategy.InterestStrategy;

@AllArgsConstructor
@NoArgsConstructor
public class LoanManagerImpl implements LoanManager {

    private LoanDao loanDao;
    private InterestStrategy interestStrategy;

    @Override
    public LoanEntry addLoan(LoanEntry loanEntry) {
        calculateEmiPayments(loanEntry);
        return loanDao.addLoan(loanEntry);
    }

    @Override
    public LoanEntry getLoan(String userName) {
        return loanDao.getLoan(userName);
    }

    private void calculateEmiPayments(LoanEntry loanEntry) {
        double interest = interestStrategy.calculateInterest(loanEntry.getPrincipalAmopunt(), loanEntry.getInterestRate(), loanEntry.getLoanTenure());
        double totalAmount = loanEntry.getPrincipalAmopunt() + interest;
        double emi = totalAmount / (loanEntry.getLoanTenure() * 12);
        for (int i = 0; i < loanEntry.getLoanTenure() * 12; i++) {
            loanEntry.getEmiPayments().add(emi);
        }
        loanEntry.setPrincipalAmopunt(totalAmount);
    }
}
