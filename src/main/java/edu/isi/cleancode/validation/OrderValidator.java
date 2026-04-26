package edu.isi.cleancode.validation;

import edu.isi.cleancode.model.Order;
import edu.isi.cleancode.model.OrderItem;

public class OrderValidator {

    public ValResult validate(Order order) {
        ValResult result = new ValResult();

        if (order == null) {
            result.addError("Order cannot be null.");
            return result;
        }

        if (order.getId() == null || order.getId().isBlank()) {
            result.addError("Order ID cannot be null or blank.");
        }

        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            result.addError("Customer name cannot be null or blank.");
        }

        if (order.getCountryCode() == null || order.getCountryCode().isBlank()) {
            result.addError("Country code cannot be null or blank.");
        }

        if (order.getItems().isEmpty()) {
            result.addError("Order must contain at least one item.");
        } else {
            for (OrderItem item : order.getItems()) {
                if (item.getQuantity() <= 0) {
                    result.addError("Item quantity must be greater than zero.");
                }
                if (item.getUnitPrice() <= 0) {
                    result.addError("Item unit price must be greater than zero.");
                }
            }
        }

        return result;
    }
}
