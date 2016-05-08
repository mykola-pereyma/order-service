package co.kiwitea.service.calculation;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import co.kiwitea.model.Order;

@Component
public class PercentageShippingPriceCalculationStrategy implements ShippingPriceCalculationStrategy {

    private static final double THOUSAND_OF_USD = 1000;
    private static final int THRESHOLD = 5;
    private static final BigDecimal SHIPPING_PERCENTAGE = BigDecimal.valueOf(0.01);

    @Override
    public boolean isApplicable(final Order order) {
        final double totalPrice = order.getOrderItems()
                .stream().mapToDouble(
                        orderItem -> orderItem.getPrice()).sum();
        final long totalItems = order.getOrderItems().stream().mapToLong(orderItem -> orderItem.getQuantity()).sum();
        return totalPrice < THOUSAND_OF_USD && totalItems > THRESHOLD;
    }

    @Override
    public double getShippingPrice(final Order order) {
        final double totalPrice = order.getOrderItems()
                .stream().mapToDouble(orderItem -> orderItem.getPrice()).sum();
        return SHIPPING_PERCENTAGE.multiply(BigDecimal.valueOf(totalPrice)).doubleValue();
    }
}
