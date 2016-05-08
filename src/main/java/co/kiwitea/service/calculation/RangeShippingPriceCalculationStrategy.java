package co.kiwitea.service.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.kiwitea.model.Order;
import co.kiwitea.service.FlatShippingPriceProvider;

@Component
public class RangeShippingPriceCalculationStrategy implements ShippingPriceCalculationStrategy {

    public static final double THOUSAND_OF_USD = 1000;
    public static final double HALF_THOUSAND_OF_USD = 500;

    @Autowired
    private FlatShippingPriceProvider flatShippingPriceProvider;

    @Override
    public boolean isApplicable(final Order order) {
        final double totalPrice = order.getOrderItems()
                .stream().mapToDouble(orderItem -> orderItem.getPrice()).sum();
        return totalPrice > HALF_THOUSAND_OF_USD && totalPrice < THOUSAND_OF_USD;
    }

    @Override
    public double getShippingPrice(final Order order) {
        return flatShippingPriceProvider.getShippingPrice();
    }
}
