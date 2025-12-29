import java.util.List;
public class ClothingFactory extends ProductFactory {
    private final List<String> productNames = List.of("shirt", "pants", "shoes");
    private final List<String> sizeOptions = List.of("small", "medium", "large");
    private final List<String> colorOptions = List.of("red", "blue");
    private final List<String> designOptions = List.of("design", "none");
    private final List<String> textOptions = List.of("text", "none");

    public Clothing createProduct(String type) {
        return switch (type.toLowerCase()) {
            case "shirt" -> new Shirt();
            case "pants" -> new Pants();
            case "shoes" -> new Shoes();
            default -> throw new IllegalArgumentException("Invalid input for createProduct() - " + type);
        };
    }

    public Clothing decorateProduct(String[] decoratorType, Clothing clothing) {
        return switch(decoratorType[0].toLowerCase()) {
            case "small"  -> new Small(clothing);
            case "medium" -> new Medium(clothing);
            case "large"  -> new Large(clothing);
            case "red"    -> new Red(clothing);
            case "blue"   -> new Blue(clothing);
            case "text"   -> new AddText(clothing, decoratorType[1]);
            case "design" -> new AddDesign(clothing);
            default -> throw new IllegalArgumentException("Invalid input for createProduct() - " + decoratorType[0]);
        };
    }

    @Override
    public List<String> getProductNames() {
        return productNames;
    }

    @Override
    public List<String> getSizeOptions() {
        return sizeOptions;
    }

    @Override
    public List<String> getColorOptions() {
        return colorOptions;
    }

    @Override
    public List<String> getDesignOptions() {
        return designOptions;
    }

    @Override
    public List<String> getTextOptions() {
        return textOptions;
    }
}
