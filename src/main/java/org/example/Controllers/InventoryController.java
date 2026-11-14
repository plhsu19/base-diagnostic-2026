//import com.sun.net.httpserver.HttpsServer;
//import org.example.services.InventoryService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/inventory")
//class InventoryController {
//    private final InventoryService inventoryService;
//
//    InventoryController(InventoryService inventoryService) {
//        this.inventoryService = inventoryService;
//    }
//
//    @PostMapping("/{sku}/reservations")
//    ReservationResponse reserve(
//        @PathVariable("sku") String sku,
//        @RequestBody ReservationRequest request) {
//        try {
//            int remaining = inventoryService.reserve(sku, request.quantity());
//            return new ReservationResponse(sku, remaining);
//        } catch (IllegalStateException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(Map.of("message", e.getMessage()));
//        }
//    }
//}
//
//record ReservationRequest(int quantity) {
//}
//
//record ReservationResponse(String sku, int remainingStock) {
//}
