package co.kiwitea.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import co.kiwitea.Application;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class OrderControllerTest {

    public static final String SHIPPING_PRICE_URL = "http://localhost:8888/orders/{orderId}/shipping/price";
    private static final String FLAT_SHIPPING_COTS = "20.0";
    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetFlatShippingPrice() throws Exception {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("orderId", "1");
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(SHIPPING_PRICE_URL, String.class, vars);
        assertEquals("shipping cost", FLAT_SHIPPING_COTS, apiResponse.getBody());
    }

    @Test
    public void testGetFreetShippingPrice() throws Exception {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("orderId", "2");
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(SHIPPING_PRICE_URL, String.class, vars);
        assertEquals("shipping cost", "0.0", apiResponse.getBody());
    }

    @Test
    public void testGetRangeShippingPrice() throws Exception {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("orderId", "3");
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(SHIPPING_PRICE_URL, String.class, vars);
        assertEquals("shipping cost", FLAT_SHIPPING_COTS, apiResponse.getBody());
    }
    @Test
    public void testGetPercentageShippingPrice() throws Exception {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("orderId", "4");
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(SHIPPING_PRICE_URL, String.class, vars);
        assertEquals("shipping cost", "8.0", apiResponse.getBody());
    }
    @Test
    public void testGetOldStockShippingPrice() throws Exception {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("orderId", "5");
        ResponseEntity<String> apiResponse = restTemplate.getForEntity(SHIPPING_PRICE_URL, String.class, vars);
        assertEquals("shipping cost", FLAT_SHIPPING_COTS, apiResponse.getBody());
    }
}
