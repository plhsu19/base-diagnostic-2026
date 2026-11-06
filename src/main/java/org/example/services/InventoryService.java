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
        throw new UnsupportedOperationException("Not implemented");
    }

    public int reserve(String sku, int quantity) {
        // TODO: reserve stock and return the remaining available stock.
        throw new UnsupportedOperationException("Not implemented");
    }
}
