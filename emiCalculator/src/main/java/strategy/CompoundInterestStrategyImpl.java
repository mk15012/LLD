package strategy;

public class CompoundInterestStrategyImpl implements InterestStrategy {

    @Override
    public double calculateInterest(double principalAmount, double interestRate, int loanTenure) {
        return principalAmount * (Math.pow((interestRate / 100), loanTenure));
    }
}
