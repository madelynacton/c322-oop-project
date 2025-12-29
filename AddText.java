public class AddText extends CustomizeDecorator {
    private String customText;
    public AddText(Clothing clothing, String customText) {
        this.clothing = clothing;
        this.customText = customText;
    }

    public double cost() {
        return clothing.cost() + 10.00;
    }

    public String getDescription() {
        return clothing.getDescription() + "and custom text: " + getCustomText();
    }

    private String getCustomText() {
        if (customText != null || !customText.equals("")) {
            return customText + " ";
        }
        return "";
    }
}
