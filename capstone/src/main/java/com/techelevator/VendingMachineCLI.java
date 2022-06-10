package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class VendingMachineCLI {

    private VendingMachine vendingMachine = new VendingMachine();
    public BuyerAccount buyerAccount = new BuyerAccount();
    public PurchaseMenu purchaseMenu = new PurchaseMenu();

    public static void main(String[] args) {
        VendingMachineCLI cli = new VendingMachineCLI();
        cli.run();
    }

    public void run() {

        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println(" ");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            String input = userInput.nextLine();

            if (input.equals("1")) {
                vendingMachine.showInventory();
            }
            if (input.equals("2")) {
                purchaseMenu.purchaseMenu(vendingMachine, buyerAccount);
            }
            if (input.equals("3")) {
                break;
            }
        }

    }   // run ends
}
