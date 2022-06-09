package com.techelevator;

import java.math.BigDecimal;

public class GumSlot extends Slot{
    //    Item Type name
    private String type = "Gum";

    //    The dispense message.
    private String dispenseMessage = "Chew Chew, Yum!";

    public GumSlot(String slotLocation, String productName, BigDecimal price){
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
