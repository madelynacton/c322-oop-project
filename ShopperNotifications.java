import java.util.ArrayList;
import java.util.List;
public class ShopperNotifications implements Subject {
    private List<Observer> shoppers;

    public ShopperNotifications() {
        shoppers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        shoppers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        shoppers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : shoppers) {
            o.update(message);
        }
    }

    public void newProductNoti(String productName){
        notifyObservers("New product available: " + productName + "!");
    }

    public void productSaleNoti(String productName, float salePrice){
        notifyObservers(productName + " is currently on sale for $" + salePrice);
    }

    public void orderUpdates(String orderStatus){
        notifyObservers("Order update: " + orderStatus);
    }
}
