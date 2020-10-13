package pos.machine;

import java.util.List;

public class Receipt {
    private List<Item> item;
    private int total;

    public Receipt(List<Item> item, int total) {
        this.item = item;
        this.total = total;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
