package org.example.services;

import java.util.HashMap;
import java.util.Map;

public final class InventoryService {
    private final Map<String, Integer> stock;

    public InventoryService(Map<String, Integer> initialStock) {
        this.stock = new HashMap<>(initialStock);
    }

    public int available(String sku) {
        // TODO: return the current available stock.
        // check if sku is null, blank, or unknown
        if (!isValidStock(sku)) {
            throw new IllegalArgumentException("invalid Stock Name");
        }
        return stock.get(sku);
    }

    public int reserve(String sku, int quantity) {
        // TODO: reserve stock and return the remaining available stock.
        // check if sku is null, blank, or unknown
        if (!isValidStock(sku)) {
            throw new IllegalArgumentException("invalid Stock Name");
        }
        // check if the quantity to reserve is valid
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity to reserve is not positive");
        }
        // check if the updated quantity is still >= 0
        int updatedQuantity = stock.get(sku) - quantity;
        if (updatedQuantity >= 0) {
            stock.replace(sku, updatedQuantity);
        } else {
            throw new IllegalStateException(String.format("insufficient stock of %s to reserve", sku));
        }
        return updatedQuantity;
    }

    private boolean isValidStock(String sku) {
        if (sku == null) {
            return false;
        }
        if (sku.trim().isBlank()) {
            return false;
        }
        return stock.containsKey(sku);
    }
}
