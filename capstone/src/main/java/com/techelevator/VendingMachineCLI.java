package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {
    private VendingMachine vendingMachine = new VendingMachine();
    public BuyerAccount buyerAccount = new BuyerAccount();

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
                System.out.println("Current Money Provided: $0.00");
                System.out.println("");
                System.out.println("(1) Feed Money");
                System.out.println("(2) Select Product");
                System.out.println("(3) Finish Transaction");
                break;
            }
            if (input.equals("3")) {
                break;
            }
        }
        String input = userInput.nextLine();
        if (input.equals("1")) {
            while (true) {
                System.out.println("Enter a whole dollar amount: ");
                BigDecimal dollarAmount = new BigDecimal(userInput.nextLine());
                buyerAccount.setBalance(dollarAmount);
                System.out.printf("Current Money Provided: $%s", buyerAccount.getBalance());
                System.out.println("");
                System.out.println("(1) Feed Money");
                System.out.println("(2) Select Product");
                System.out.println("(3) Finish Transaction");

                input = userInput.nextLine();

                if (input.equals("2")) {
                    vendingMachine.showInventory();
                    System.out.println("Enter a valid code: ");

                    String slotName = userInput.nextLine();
                    // Buyer tries to purchase an item
                   vendingMachine.purchaseItem(buyerAccount.getBalance(),slotName);
                    break;
                }
                if (input.equals("3")) {
                    break;
                }
            }
        }
    }

}
