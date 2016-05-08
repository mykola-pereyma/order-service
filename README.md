# order-service
This REST service handle just one endpoint that provide order shipping price.

http://localhost:8080/orders/{orderId}/shipping/price

Design consideration:

Rest service should simple but allowing to extend price calcuation strategy.

Out of scope:

1. Security

2. Full coverage with unit tests

3. Entity persitance

4. Perfomance optimization

Requirements to build and run:

1. Java 8

2. Maven

3. Internet to load Maven dependencies

To build service please run:

mvn package

To run service:

mvn spring-boot:run
