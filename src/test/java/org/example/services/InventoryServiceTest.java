package org.example.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryService service;
    private Map<String, Integer> defaultStock;

    @BeforeEach
    void setUp() {
        defaultStock = Map.of("PEN", 5, "BOOK", 2);
        service = new InventoryService(
            defaultStock
        );
    }

    @Test
    void availableReturnsCurrentAvailableStock() {
        // Arrange: prepare any additional data for this case.
        // Act: call the service method you want to test.
        // Assert: verify the expected result or observable state.
        int penStock = service.available("PEN");
        int bookStock = service.available("BOOK");
        assertEquals(5, penStock);
        assertEquals(2, bookStock);
    }
    @Test
    void availableThrowsExceptionWithInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> service.available(null));
        assertThrows(IllegalArgumentException.class, () -> service.available(""));
        assertThrows(IllegalArgumentException.class, () -> service.available("BALL"));
        assertThrows(IllegalArgumentException.class, () -> service.available("Pen"));
    }
    @Test
    void reserveReservesQuantitiesAndReturnsCurrentAvailableStock() {
        int afterReservedPenStock = service.reserve("PEN", 3);
        int afterReservedBookStock = service.reserve("BOOK", 2);
        assertEquals(2, afterReservedPenStock);
        assertEquals(0, afterReservedBookStock);
    }
    @Test
    void reserveThrowsExceptionWithInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> service.reserve(null, 2));
        assertThrows(IllegalArgumentException.class, () -> service.reserve("", 2));
        assertThrows(IllegalArgumentException.class, () -> service.reserve("BALL", 2));
        assertThrows(IllegalArgumentException.class, () -> service.reserve("Pen", 2));
        assertThrows(IllegalArgumentException.class, () -> service.reserve("PEN", 0));
        assertThrows(IllegalStateException.class, () -> service.reserve("PEN", 6));
    }
}

















