package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTests {

    @Test
    public void purchase_Valid_Item_With_Enough_Money_Returns_New_balance() {
//      Arrange
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal balance = new BigDecimal(10);
        String slotName = "A1";
        BuyerAccount buyerAccount = new BuyerAccount();

//        Act
        BigDecimal expected = new BigDecimal(6.95);
        BigDecimal actual = vendingMachine.purchaseItem(balance,slotName);
//        Assert
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.00);
    }
}
