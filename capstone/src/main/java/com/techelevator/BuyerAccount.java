package com.techelevator;

import java.math.BigDecimal;

public class BuyerAccount {

    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
