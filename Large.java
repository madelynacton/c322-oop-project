public class Large extends SizeDecorator {
    public Large(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in the size large ";
    }

    @Override
    public double cost() {
        return clothing.cost() + 10;
    }
}
