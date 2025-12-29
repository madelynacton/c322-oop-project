public class Small extends SizeDecorator {
    public Small(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in the size small ";
    }

    @Override
    public double cost() {
        return clothing.cost();
    }

}
