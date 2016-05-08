package co.kiwitea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kiwitea.model.Category;
import co.kiwitea.model.Item;
import co.kiwitea.model.Order;
import co.kiwitea.model.OrderItem;

/**
 * Stub for Order service that provide predefined types of orders
 */
@Service
public class OrderService {

    private final Category REGULAR_CATEGORY = new Category(1, "Regular");
    private final Category OLD_STOCK_CATEGORY = new Category(2, "Old Stock");
    private final Item ITEM_100_USD = new Item(1, "Tea 100", 100, REGULAR_CATEGORY);
    private final Item ITEM_200_USD = new Item(1, "Tea 200", 200, REGULAR_CATEGORY);
    private final Item ITEM_500_USD = new Item(1, "Tea 500", 500, REGULAR_CATEGORY);
    private final Item ITEM_1000_USD = new Item(1, "Tea 1000", 1000, REGULAR_CATEGORY);
    private final Item ITEM_FROM_OLD_STOCK = new Item(1, "Tea 100", 100, OLD_STOCK_CATEGORY);

    @Autowired
    ShippingPriceService shippingPriceService;

    public double getShippingPrice(final int orderId){
        final Order order = getOrder(orderId);
        return shippingPriceService.getShippingPrice(order);

    }

    public Order getOrder(final int id) {
        switch (id) {
            case 1:
                return getFlatPriceOrder();
            case 2:
                return getFreePriceOrder();
            case 3:
                return getRangePriceOrder();
            case 4:
                return getPercentagePriceOrder();
            case 5:
                return getOldStockPriceOrder();
            default:
                return getFlatPriceOrder();
        }
    }

    private Order getOldStockPriceOrder() {
        return new Order()
                .addOrderItem(new OrderItem(ITEM_200_USD, 1))
                .addOrderItem(new OrderItem(ITEM_FROM_OLD_STOCK, 1));
    }

    private Order getPercentagePriceOrder() {
        return new Order()
                .addOrderItem(new OrderItem(ITEM_200_USD, 1))
                .addOrderItem(new OrderItem(ITEM_100_USD, 1))
                .addOrderItem(new OrderItem(ITEM_100_USD, 3))
                .addOrderItem(new OrderItem(ITEM_100_USD, 2));
    }

    private Order getRangePriceOrder() {
        return new Order()
                .addOrderItem(new OrderItem(ITEM_200_USD, 1))
                .addOrderItem(new OrderItem(ITEM_500_USD, 1));
    }

    private Order getFreePriceOrder() {
        return new Order()
                .addOrderItem(new OrderItem(ITEM_1000_USD, 1))
                .addOrderItem(new OrderItem(ITEM_1000_USD, 1));
    }

    private Order getFlatPriceOrder() {
        return new Order()
                .addOrderItem(new OrderItem(ITEM_100_USD, 1));
    }
}
