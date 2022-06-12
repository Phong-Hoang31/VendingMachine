package com.techelevator;

import java.math.BigDecimal;

public abstract class Slot {

    private String type;
    //    The slot location in the vending machine containing the product.
    private String slotLocation;
//    The display name of the vending machine product.
    private String productName;
//    The purchase price for the product.
    private BigDecimal price;



    //    The remaining number of items
    private int numberRemaining = 5;

    public Slot(String slotLocation, String productName, BigDecimal price){
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
    }
    private String dispenseMessage = "Glug Glug, Yum!";


    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberRemaining() {
        return numberRemaining;
    }

    public String getType() {
        return type;
    }
    public String getDispenseMessage() {
        return dispenseMessage;
    }

    public void setNumberRemaining(int numberRemaining) {
        this.numberRemaining = numberRemaining;
    }
}
