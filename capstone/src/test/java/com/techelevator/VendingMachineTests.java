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
    @Test
    public void purchase_Invalid_Item_With_Enough_Money_Return_Initial_Balance() {
//      Arrange
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal balance = new BigDecimal(10);
        String slotName = "D5";
        BuyerAccount buyerAccount = new BuyerAccount();

//        Act
        BigDecimal expected = balance;
        BigDecimal actual = vendingMachine.purchaseItem(balance,slotName);
//        Assert
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.00);
    }
    @Test
    public void purchase_Valid_Item_With_Not_Enough_Money() {
//      Arrange
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal balance = new BigDecimal(1);
        String slotName = "A1";
        BuyerAccount buyerAccount = new BuyerAccount();

//        Act
        BigDecimal expected = balance;
        BigDecimal actual = vendingMachine.purchaseItem(balance,slotName);
//        Assert
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.00);
    }
    @Test
    public void purchase_Valid_Item_With_Not_Enough_Quantity() {
//      Arrange
        VendingMachine vendingMachine = new VendingMachine();
        BigDecimal balance = new BigDecimal(10);
        String slotName = "A1";
        BuyerAccount buyerAccount = new BuyerAccount();
        for (Slot slot : vendingMachine.getInventory()) {

            if (slot.getSlotLocation().equals(slotName)) {
                slot.setNumberRemaining(0);
            }
        }
//        Act
        BigDecimal expected = balance;
        BigDecimal actual = vendingMachine.purchaseItem(balance,slotName);
//        Assert
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.00);
    }
//    @Test
//    public void get_change() {
////      Arrange
//        PurchaseMenu purchaseMenu = new PurchaseMenu();
//        BigDecimal balance = new BigDecimal(10);
//        BuyerAccount buyerAccount = new BuyerAccount();
//        buyerAccount.setBalance(balance);
//
////        Act
//        BigDecimal[] expected = {BigDecimal.valueOf(40), BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
//        BigDecimal[] actual = purchaseMenu.getChange(buyerAccount);
//        BigDecimal[] delta = {BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO};
////        Assert
//        Assert.assertArrayEquals(expected, actual, delta);
//
//    }
}
