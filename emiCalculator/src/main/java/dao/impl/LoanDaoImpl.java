package dao.impl;

import dao.LoanDao;
import entry.LoanEntry;

import java.util.HashMap;
import java.util.Map;

public class LoanDaoImpl implements LoanDao {

    static Map<String, LoanEntry> loanEntryMap;

    public LoanDaoImpl() {
        loanEntryMap = new HashMap<>();
    }

    public static Map<String, LoanEntry> getLoanEntryMap() {
        return loanEntryMap;
    }

    @Override
    public LoanEntry getLoan(String userName) {
        return loanEntryMap.get(userName);
    }

    @Override
    public LoanEntry addLoan(LoanEntry loanEntry) {
        if (loanEntryMap.containsKey(loanEntry.getCustomerUserName())) {
            System.out.println("Load already exists");
            return loanEntry;
        }
        loanEntryMap.put(loanEntry.getCustomerUserName(), loanEntry);
        System.out.println("Loan " + loanEntry.getCustomerUserName() + " added successfuly");
        return loanEntry;
    }

}

