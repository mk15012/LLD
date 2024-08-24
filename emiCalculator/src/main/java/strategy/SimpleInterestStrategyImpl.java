package strategy;

public class SimpleInterestStrategyImpl implements InterestStrategy {

    @Override
    public double calculateInterest(double principalAmount, double interestRate, int loanTenure) {
        return ( principalAmount * interestRate * loanTenure ) / 100;
    }
}
