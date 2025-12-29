public class Shopper implements Observer{
    private String name;
    private ShopView view;

    public Shopper(String name, ShopView view) {
        this.name = name;
        this.view = view;
    }

    @Override
    public void update(String message) {
        if (view != null) {
            view.appendNotification("Hello " + name + "! " + message);
        }
    }
}
