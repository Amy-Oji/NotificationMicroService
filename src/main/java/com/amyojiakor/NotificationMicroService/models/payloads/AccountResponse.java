package com.amyojiakor.NotificationMicroService.models.payloads;

import com.amyojiakor.NotificationMicroService.models.emums.AccountType;
import com.amyojiakor.NotificationMicroService.models.emums.CurrencyCode;

import java.math.BigDecimal;

public record AccountResponse(String email, String accountNumber, String accountName, AccountType accountType, CurrencyCode currencyCode, BigDecimal accountBalance) {


}
