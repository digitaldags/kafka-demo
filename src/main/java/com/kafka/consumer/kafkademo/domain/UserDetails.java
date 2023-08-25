package com.kafka.consumer.kafkademo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetails {
    private String channel;
    private String requestType;
    private String cardNo;
    private String amount;
    private String maximumEligibleAmount;
    private String monthsToPay;
    private String interestRate;
    private String monthlyPayment;
    private String monthlyRate;
    private String shortCode;
    private String merchantName;
    private String contactNo;
    private String email;
    private ProcessingFee processingFee;
    private OtherCards otherCards;
}
