package co.kiwitea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

import co.kiwitea.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/{orderId}/shipping/price", method = RequestMethod.GET)
    public String getShippingPrice(@PathVariable final int orderId) {
        final DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        final double shippingPrice = orderService.getShippingPrice(orderId);
        return decimalFormat.format(shippingPrice);
    }
}
