package co.kiwitea.service.calculation;

import org.springframework.stereotype.Component;

import co.kiwitea.model.Order;

@Component
public class FreeShippingPriceCalculationStrategy implements ShippingPriceCalculationStrategy {

    public static final double THOUSAND_OF_USD = 1000;

    @Override
    public boolean isApplicable(final Order order) {
        return order.getOrderItems()
                .stream().mapToDouble(orderItem -> orderItem.getPrice()).sum() > THOUSAND_OF_USD;
    }

    @Override
    public double getShippingPrice(final Order order) {
        return 0;
    }
}
