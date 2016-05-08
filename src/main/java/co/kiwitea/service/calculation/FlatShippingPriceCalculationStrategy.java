package co.kiwitea.service.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.kiwitea.model.Order;
import co.kiwitea.service.FlatShippingPriceProvider;

@Component
public class FlatShippingPriceCalculationStrategy implements ShippingPriceCalculationStrategy {

    @Autowired
    private FlatShippingPriceProvider flatShippingPriceProvider;

    @Override
    public boolean isApplicable(final Order order) {
        return true;
    }

    @Override
    public double getShippingPrice(final Order order) {
        return flatShippingPriceProvider.getShippingPrice();
    }
}
