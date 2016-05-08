package co.kiwitea.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order addOrderItem(final OrderItem orderItem){
        orderItems.add(orderItem);
        return this;
    }
}
