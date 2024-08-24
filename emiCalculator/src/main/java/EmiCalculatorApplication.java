import entry.LoanEntry;
import entry.UserEntry;
import service.LoanService;
import service.UserService;
import service.impl.LoanServiceImpl;
import service.impl.UserServiceImpl;

public class EmiCalculatorApplication {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        LoanService loanService = new LoanServiceImpl();

        // Create users
        userService.addUser(new UserEntry("admin1", true));
        userService.addUser(new UserEntry("customer1", false));
        userService.addUser(new UserEntry("customer2", false));

        // Create loans by admin
        loanService.addLoan(new LoanEntry("admin1", "customer1", 10000, 5.0, 2));
        loanService.addLoan(new LoanEntry("admin1", "customer2", 5000, 4.0, 2));

//        // Customer makes EMI payment
//        loanService.makeEmiPayment("customer1", 500);
//
//        // Fetch loan info for customer
//        loanService.fetchLoanInfo("customer1", "customer1");
//
//        // Admin fetches all loans
//        loanService.fetchAllLoans("admin1");

    }
}