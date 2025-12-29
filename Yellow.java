public class Yellow extends ColorDecorator {
    public Yellow(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in yellow ";
    }

    @Override
    public double cost() {
        return clothing.cost();
    }
}
