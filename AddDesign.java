public class AddDesign extends CustomizeDecorator {
    public AddDesign(Clothing clothing) {
        this.clothing = clothing;
    }

    public double cost() {
        return clothing.cost() + 15.50;
    }

    public String getDescription() {
        return clothing.getDescription() + "and a custom design ";
    }
}
