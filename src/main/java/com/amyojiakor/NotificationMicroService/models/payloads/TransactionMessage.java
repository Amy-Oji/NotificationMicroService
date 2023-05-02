package com.amyojiakor.NotificationMicroService.models.payloads;

import com.amyojiakor.NotificationMicroService.models.emums.TransactionType;

import java.math.BigDecimal;

public record TransactionMessage(String accountNum, TransactionType transactionType, BigDecimal amount){
}
