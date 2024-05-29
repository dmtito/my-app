package com.mycompany.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {
    private final FraudCheckRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }

    public FraudService(FraudCheckRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }
}
