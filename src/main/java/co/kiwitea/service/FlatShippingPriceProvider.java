package co.kiwitea.service;

import org.springframework.stereotype.Component;

@Component
public class FlatShippingPriceProvider {

    public static final int FLAT_PRICE = 20;

    public double getShippingPrice(){
        return FLAT_PRICE;
    }
}
