import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopController {
    private final ShopModel model;
    private final ShopView view;
    private final ProductFactory factory;

    ShopperNotifications store;

    public ShopController(ShopModel model, ShopView view, ProductFactory factory, ShopperNotifications store) {
        this.model   = model;
        this.view    = view;
        this.factory = factory;
        this.store = store;

        view.getOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setBaseProduct(view.getSelectedProduct(), factory);

                String size = view.getSelectedSize();
                if (!"none".equals(size)) {
                    model.addCustomization(new String[] {size}, factory);
                }

                String color = view.getSelectedColor();
                if (!"none".equals(color)) {
                    model.addCustomization(new String[] {color}, factory);
                }

                String design = view.getSelectedDesign();
                if (!"none".equals(design)) {
                    model.addCustomization(new String[] {design}, factory);
                }

                String userText = view.getEnteredText();
                if (!userText.isEmpty()) {
                    model.addCustomization(new String[] {"text", userText}, factory);
                }

                String desc = model.getDescription();
                double cost = model.getCost();

                String paymentMethod = view.getSelectedPaymentMethod();
                String shippingMethod = view.getSelectedShippingMethod();
                double tax = model.getTax(cost, paymentMethod, shippingMethod);

                cost += tax;

                view.setOutput(String.format("%s%nTotal: $%.2f", desc, cost));

                store.orderUpdates("Your order has been ordered of " + desc + "for $" + String.format("%.2f", cost));
            }
        });
    }
}
