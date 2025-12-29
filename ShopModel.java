public class ShopModel {
    private Clothing current;

    public void setBaseProduct(String type, ProductFactory factory) {
        current = factory.createProduct(type);
    }

    public void addCustomization(String[] decorator, ProductFactory factory) {
        current = factory.decorateProduct(decorator, current);
    }

    public String getDescription() {
        return current == null ? "" : current.getDescription();
    }

    public double getCost() {
        return current == null ? 0.0 : current.cost() ;
    }

    public double getTax(double clothingCost, String paymentMethod, String shippingMethod) {
        double tax = 0.0;
        if (paymentMethod.equalsIgnoreCase("card")) {
            PaymentMethod creditCard = new CreditCard();
            creditCard.setTaxBehavior(new CreditCardFee());
            tax = creditCard.calculateTax(clothingCost);
            tax += clothingCost;
        } else if (paymentMethod.equalsIgnoreCase("paypal")) {
            PaymentMethod payPal = new PayPal();
            payPal.setTaxBehavior(new NoFee());
            tax = payPal.calculateTax(clothingCost);
            tax += clothingCost;
        }

        if (shippingMethod.equalsIgnoreCase("standard shipping")) {
            tax += 7.50;
        } else if (shippingMethod.equalsIgnoreCase("next day")) {
            tax += 25;
        }
        return tax;
    }
}