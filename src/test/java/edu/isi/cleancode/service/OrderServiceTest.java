package edu.isi.cleancode.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    void calculateTotal_forPeruPriorityOrder_shouldIncludePriorityShippingAndTax() {
        Order order = new Order("ORD-1", "Grace Hopper", "PE", true);
        order.addItem(new OrderItem("BOOK", 2, 50));

        double total = service.calculateTotal(order);

        assertEquals(133.0, total);
    }

    @Test
    void calculateTotal_forLargeRegularOrder_shouldHaveFreeShipping() {
        Order order = new Order("ORD-2", "Alan Turing", "PE", false);
        order.addItem(new OrderItem("KIT", 1, 200));

        double total = service.calculateTotal(order);

        assertEquals(102.0, total);
    }

    @Test
    void calculateTotal_forHondurasRegularOrder_shouldUse15PercentTax() {
        Order order = new Order("ORD-3", "Katherine Johnson", "HN", false);
        order.addItem(new OrderItem("MOUSE", 1, 100));

        double total = service.calculateTotal(order);

        assertEquals(135.0, total);
    }

    //CASO FRONTERA PAIS NO CONOCIDO
    @Test
    void calculateTotal_forUnknownCountry_shouldUseDefaultTax() {
        Order order = new Order("ORD-4", "Abraham Reyes", "IN", false);
        order.addItem(new OrderItem("KIT", 1, 200));

        double total = service.calculateTotal(order);

        assertEquals(230.0, total);
    }

    //CASO FRONTERA EXACTO LIMITE ENVIO GRATIS
    @Test
    void calculateTotal_forExactFreeShippingThreshold_shouldHaveFreeShipping() {
        Order order = new Order("ORD-5", "vanessa Rodiguez", "PE", false);
        order.addItem(new OrderItem("KIT", 1, 200)); 

        double total = service.calculateTotal(order);

        assertEquals(236.0, total); 
    }

    //CASO FRONTERA PRIORITY EN PAIS CON ENVIO PRIORITARIO
    void calculateTotal_forInternationalPriorityOrder_shouldUseHigherShipping() {
        Order order = new Order("ORD-6", "Tommy Morales", "US", true);
        order.addItem(new OrderItem("KIT", 1, 200));

        double total = service.calculateTotal(order);

        assertEquals(250.0, total);
    }


}
