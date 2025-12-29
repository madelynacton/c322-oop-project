public class Medium extends SizeDecorator {
    public Medium(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in the size medium ";
    }

    @Override
    public double cost() {
        return clothing.cost() + 5;
    }
}
