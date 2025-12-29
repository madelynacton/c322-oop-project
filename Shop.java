import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Shop {

    public static void main(String[] args) {
        ProductFactory factory = new ClothingFactory();
        ShopModel model = new ShopModel();
        ShopView view = new ShopView(factory);
        ShopperNotifications store = new ShopperNotifications();
        ShopController controller = new ShopController(model, view, factory, store);

        Shopper shopper = new Shopper("User", view);
        store.registerObserver(shopper);
        store.newProductNoti("Shirt");
        store.newProductNoti("Pants");
        store.newProductNoti("Shoes");
    }    
}

