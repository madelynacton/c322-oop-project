import java.util.List;

public abstract class ProductFactory {
    public abstract Clothing createProduct(String type);
    public abstract Clothing decorateProduct(String[] type, Clothing clothing);

    public abstract List<String> getProductNames();
    public abstract List<String> getSizeOptions();
    public abstract List<String> getColorOptions();
    public abstract List<String> getDesignOptions();
    public abstract List<String> getTextOptions();
}
