public class CreditCardFee implements SalesTaxBehavior{
    @Override
    public double compute(Double value) {
        return value * 0.05;
    }
}
