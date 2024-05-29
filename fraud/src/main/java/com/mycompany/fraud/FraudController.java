package com.mycompany.fraud;

import com.mycompany.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud")
public class FraudController {
    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    private final FraudService fraudService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse checkFraud(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check for customer {}", customerId);
        return new FraudCheckResponse(fraudService.isFraudulentCustomer(customerId));
    }
}
