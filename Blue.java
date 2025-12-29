public class Blue extends ColorDecorator {
    public Blue(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in blue ";
    }

    @Override
    public double cost() {
        return clothing.cost() + 1;
    }
}
