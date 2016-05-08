package co.kiwitea.service.calculation;

import co.kiwitea.model.Order;

public interface ShippingPriceCalculationStrategy {

    boolean isApplicable(final Order order);

    double getShippingPrice(final Order order);

}
