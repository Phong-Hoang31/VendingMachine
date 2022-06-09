package com.techelevator;

import java.math.BigDecimal;

public class ChipsSlot extends Slot {
    //    Item Type name
    private String type = "Chip";

    //    The dispense message.
    private String dispenseMessage = "Crunch Crunch, Yum!";

    public ChipsSlot(String slotLocation, String productName, BigDecimal price) {
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
