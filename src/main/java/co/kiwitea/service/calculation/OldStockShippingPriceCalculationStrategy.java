package co.kiwitea.service.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.kiwitea.model.Order;
import co.kiwitea.service.FlatShippingPriceProvider;

@Component
public class OldStockShippingPriceCalculationStrategy implements ShippingPriceCalculationStrategy {

    public static final String OLD_STOCK_CATEGORY_NAME = "Old Stock";

    @Autowired
    private FlatShippingPriceProvider flatShippingPriceProvider;

    @Override
    public boolean isApplicable(final Order order) {
        return order.getOrderItems()
                .stream()
                .filter(orderItem ->
                                OLD_STOCK_CATEGORY_NAME.equals(orderItem.getItem().getCategory().getName())
                ).count() > 0;
    }

    @Override
    public double getShippingPrice(final Order order) {
        return flatShippingPriceProvider.getShippingPrice();
    }
}
