public abstract class PaymentMethod {
    SalesTaxBehavior salesTaxBehavior;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaxBehavior(SalesTaxBehavior taxBehavior) {
        this.salesTaxBehavior = taxBehavior;
    }

    public double calculateTax(Double value) {
        double tax = salesTaxBehavior.compute(value);
        return tax;
    }
}
