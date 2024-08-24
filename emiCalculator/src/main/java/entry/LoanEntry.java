package entry;

import enums.InterestStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntry {

    private String adminUserName;
    private String customerUserName;
    private double principalAmopunt;
    private double interestRate;
    private int loanTenure;
    private List<Double> emiPayments;
    private double remainingPricipal;
    private InterestStrategy interestStrategy;

    public LoanEntry(String adminUserName, String customerUserName, double principalAmopunt, double interestRate, int loanTenure) {
        this.adminUserName = adminUserName;
        this.customerUserName = customerUserName;
        this.principalAmopunt = principalAmopunt;
        this.interestRate = interestRate;
        this.loanTenure = loanTenure;
        this.emiPayments = new ArrayList<>();
        this.remainingPricipal = 0;
    }

    public void fetchLoanInfo() {
        System.out.println("Loan Details:");
        System.out.println("Admin Username: " + getAdminUserName());
        System.out.println("Customer Username: " + getCustomerUserName());
        System.out.println("Principal Amount: " + getPrincipalAmopunt());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Tenure: " + getLoanTenure());
        System.out.println("EMI Payments Done: " + (getLoanTenure() * 12 - emiPayments.size()));
        System.out.println("Remaining Principal: " + getRemainingPricipal());
        System.out.println("Remaining EMIs: " + emiPayments.size());
    }

}
