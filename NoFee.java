public class NoFee implements SalesTaxBehavior {
    public double compute(Double value) { //no tax for states
        return 0.0;
    }
}
