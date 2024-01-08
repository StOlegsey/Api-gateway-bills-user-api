package com.bills_user.bills_user_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final RestService restService;

    public MainController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("/api/genTickets")
    public ResponseEntity<?> getTickets(@RequestParam Integer event_id,
                                        @RequestParam Integer amount,
                                        @RequestParam Integer user_id) {
        try {
            List<Integer> tickets = restService.generateTickets(event_id, amount, user_id);
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/test")
    public String getMessage() {
        return  "<html><body><h1>Hello there</h1></body></html>";
    }
}
