package com.techelevator;

import java.math.BigDecimal;

public class BeverageSlot extends Slot{

    //    Item Type name
    private String type = "Drink";

    //    The dispense message.

    private String dispenseMessage = "Glug Glug, Yum!";

    public BeverageSlot(String slotLocation, String productName, BigDecimal price){
        super(slotLocation, productName, price);
    }

    @Override
    public String getDispenseMessage() {
        return dispenseMessage;
    }
    public String getType() {
        return type;
    }
}
