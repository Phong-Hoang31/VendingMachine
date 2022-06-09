package com.techelevator;

import java.math.BigDecimal;

public class CandySlot extends Slot {
    //    Item Type name
    private String type = "Candy";

    //    The dispense message.
    private String dispenseMessage = "Munch Munch, Yum!";

    public CandySlot(String slotLocation, String productName, BigDecimal price){
        super(slotLocation, productName, price);
    }
    public String getType() {
        return type;
    }
    @Override
    public String getDispenseMessage() {
        return dispenseMessage;
    }
}
