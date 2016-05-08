package co.kiwitea.model;

import java.math.BigDecimal;

public class OrderItem {
    private final Item item;
    private final long quantity;

    public OrderItem(final Item item, final long quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice(){
        return BigDecimal.valueOf(
                item.getPrice()).multiply(BigDecimal.valueOf(quantity)).doubleValue();
    }
}
