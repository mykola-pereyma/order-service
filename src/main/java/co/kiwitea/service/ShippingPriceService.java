package co.kiwitea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import co.kiwitea.model.Order;
import co.kiwitea.service.calculation.ShippingPriceCalculationStrategy;

@Service
public class ShippingPriceService {

    @Autowired
    private List<ShippingPriceCalculationStrategy> strategyList;

    public double getShippingPrice(final Order order) {
        return strategyList.stream().filter(strategy -> strategy.isApplicable(order))
                .mapToDouble(strategy -> strategy.getShippingPrice(order))
                .min()
                .orElseThrow(IllegalStateException::new);
    }
}
