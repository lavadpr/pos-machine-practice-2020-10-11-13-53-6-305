package pos.machine;

public class Item {
    private String name;
    private int quantity;
    private int unitPrice;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    private int subtotal;

    public Item(String name, int quantity, int unitPrice, int subtotal) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getSubtotal() {
        return subtotal;
    }
}
