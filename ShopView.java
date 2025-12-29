import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShopView extends JFrame {
    JComboBox<String> productCombo;
    JTabbedPane tabbedPane;
    JComboBox<String> sizeCombo;
    JComboBox<String> colorCombo;
    JComboBox<String> designCombo;
    JTextField textField;

    JComboBox<String> paymentMethodCombo;
    JComboBox<String> shippingMethodCombo;

    JButton orderButton;
    JTextArea outputArea;
    JTextArea notificationArea;

    public ShopView(ProductFactory factory) {
        super("Custom Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 540);
        setLayout(new BorderLayout(5, 5));

        JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        north.add(new JLabel("Product:"));
        productCombo = new JComboBox<>(factory.getProductNames().toArray(new String[0]));
        north.add(productCombo);
        add(north, BorderLayout.NORTH);
        tabbedPane = new JTabbedPane();

        sizeCombo = new JComboBox<>(factory.getSizeOptions().toArray(new String[0]));
        JPanel sizePanel = new JPanel(new FlowLayout());
        sizePanel.add(new JLabel("Size:"));
        sizePanel.add(sizeCombo);
        tabbedPane.addTab("Size", sizePanel);

        colorCombo = new JComboBox<>(factory.getColorOptions().toArray(new String[0]));
        JPanel colorPanel = new JPanel(new FlowLayout());
        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(colorCombo);
        tabbedPane.addTab("Color", colorPanel);

        designCombo = new JComboBox<>(factory.getDesignOptions().toArray(new String[0]));
        designCombo.setSelectedIndex(1);
        JPanel designPanel = new JPanel(new FlowLayout());
        designPanel.add(new JLabel("Design:"));
        designPanel.add(designCombo);
        tabbedPane.addTab("Design", designPanel);

        textField = new JTextField(20);
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.add(new JLabel("Custom Text:"));
        textPanel.add(textField);
        tabbedPane.addTab("Text", textPanel);

        JPanel paymentPanel = new JPanel(new FlowLayout());
        paymentPanel.add(new JLabel("Payment Method:"));
        paymentMethodCombo = new JComboBox<>(new String[]{"Card", "PayPal"});
        paymentPanel.add(paymentMethodCombo);

        JPanel shippingPanel = new JPanel(new FlowLayout());
        shippingPanel.add(new JLabel("Shipping Method:"));
        shippingMethodCombo = new JComboBox<>(new String[]{"Standard Shipping", "Next Day"});
        shippingPanel.add(shippingMethodCombo);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 1));
        optionsPanel.add(paymentPanel);
        optionsPanel.add(shippingPanel);
        tabbedPane.addTab("Options", optionsPanel);

        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);

        notificationArea = new JTextArea(5, 20);
        // notificationArea.setLineWrap(true);
        notificationArea.setEditable(false);
        notificationArea.setBorder(BorderFactory.createTitledBorder("Notifications"));
        JScrollPane notificationScroll = new JScrollPane(notificationArea);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        bottomPanel.add(outputScroll);
        bottomPanel.add(notificationScroll);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, bottomPanel);
        splitPane.setResizeWeight(0.6);
        add(splitPane, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        orderButton = new JButton("Place Order");
        south.add(orderButton);
        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Getters
    public String getSelectedProduct() {
        return (String) productCombo.getSelectedItem();
    }

    public String getSelectedSize() {
        return (String) sizeCombo.getSelectedItem();
    }

    public String getSelectedColor() {
        return (String) colorCombo.getSelectedItem();
    }

    public String getSelectedDesign() {
        return (String) designCombo.getSelectedItem();
    }

    public String getEnteredText() {
        return textField.getText().trim();
    }

    public String getSelectedPaymentMethod() {
        return (String) paymentMethodCombo.getSelectedItem();
    }

    public String getSelectedShippingMethod() {
        return (String) shippingMethodCombo.getSelectedItem();
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public JTextArea getNotificationArea() {
        return notificationArea;
    }

    public void setOutput(String s) {
        outputArea.setText(s);
    }

    public void appendNotification(String message) {
        notificationArea.append(message + "\n");
    }
}