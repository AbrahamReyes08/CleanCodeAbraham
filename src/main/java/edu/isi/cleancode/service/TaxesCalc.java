package edu.isi.cleancode.service;

import edu.isi.cleancode.model.Order;

public class TaxesCalc {
    public double calculateTaxes(Order order, double subtotal) {
        if ("HN".equals(order.getCountryCode())) {
            return round2(subtotal * 0.15);
        }
        if ("PE".equals(order.getCountryCode())) {
            return round2(subtotal * 0.18);
        }
        if ("CL".equals(order.getCountryCode())) {
            return round2(subtotal * 0.19);
        }
        return round2(subtotal * 0.15);
    }

    private double round2(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }


}

