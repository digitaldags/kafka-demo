package com.kafka.consumer.kafkademo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OtherCards {
    private String accountNo;
    private String disbursementMethod;
}
