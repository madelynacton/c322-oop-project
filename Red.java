public class Red extends ColorDecorator {
    public Red(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getDescription() {
        return clothing.getDescription() + "in red ";
    }

    @Override
    public double cost() {
        return clothing.cost();
    }
}
