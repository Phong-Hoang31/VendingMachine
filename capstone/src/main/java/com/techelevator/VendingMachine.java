package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    private List<Slot> inventory = new ArrayList<>();

    public VendingMachine() {
        File file = new File("vendingmachine.csv");
        try (
                Scanner scanner = new Scanner(file);
                Scanner scan = new Scanner("hello")) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] inputs = input.split("\\|");

                BigDecimal price = new BigDecimal(inputs[2]);

                if (inputs[3].equals("Chip")) {
                    Slot slot = new ChipsSlot(inputs[0], inputs[1], price);
                    inventory.add(slot);
                }
                if (inputs[3].equals("Candy")) {
                    Slot slot = new CandySlot(inputs[0], inputs[1], price);
                    inventory.add(slot);
                }
                if (inputs[3].equals("Drink")) {
                    Slot slot = new BeverageSlot(inputs[0], inputs[1], price);
                    inventory.add(slot);
                }
                if (inputs[3].equals("Gum")) {
                    Slot slot = new GumSlot(inputs[0], inputs[1], price);
                    inventory.add(slot);
                }
            }
        } catch (
                FileNotFoundException fnf) {
            System.out.println("can't find the file");
        }
    }

    public void showInventory() {
        for (Slot slot : inventory) {
            System.out.println(slot.getSlotLocation() + "|" + slot.getProductName() + "|$" + slot.getPrice() + "|" + slot.getNumberRemaining() + "|" + slot.getType());
        }
    }

    public BigDecimal purchaseItem(BigDecimal balance, String slotName) {
        boolean isValidCode = false;

        for (Slot slot : inventory) {

            if (slot.getSlotLocation().equals(slotName)) {

                isValidCode = true;
//                item name, cost, and the money remaining.
                if (slot.getPrice().compareTo(balance) <= 0) {
                    System.out.println(slot.getProductName() + " " + slot.getPrice() + " " + balance.subtract(slot.getPrice()));
                    System.out.println(slot.getDispenseMessage());
                    Logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a ")) + slot.getProductName() + " " + slot.getSlotLocation() + " $" + slot.getPrice() + " $" + balance.subtract(slot.getPrice()));

                    return balance.subtract(slot.getPrice());
                } else {
                    System.out.println("Not enough money");
                }
            }
        }
        if (!isValidCode) {
            System.out.println("Invalid code");
        }
        return balance;
    }

    public List<Slot> getInventory() {
        return inventory;
    }

    public void setInventory(List<Slot> inventory) {
        this.inventory = inventory;
    }
}
