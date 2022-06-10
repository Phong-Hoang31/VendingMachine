package com.techelevator;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PurchaseMenu {

    public void purchaseMenu(VendingMachine vendingMachine, BuyerAccount buyerAccount) {

        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.printf("Current Money Provided: $%s", buyerAccount.getBalance());
            System.out.println("");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");

            String input = userInput.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter a whole dollar amount: ");

                BigDecimal dollarAmount = new BigDecimal(userInput.nextLine());
                Logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a ")) + "FEED MONEY $" +  buyerAccount.getBalance().toString() + " $" + dollarAmount);
                buyerAccount.setBalance(buyerAccount.getBalance().add(dollarAmount));
            }

            if (input.equals("2")) {
                vendingMachine.showInventory();
                System.out.println("Enter a valid code: ");

                String slotName = userInput.nextLine();

                // Buyer tries to purchase an item
                buyerAccount.setBalance(vendingMachine.purchaseItem(buyerAccount.getBalance(), slotName));
            }
            if (input.equals("3")) {
                BigDecimal balance = buyerAccount.getBalance();

                BigDecimal quarterValue = new BigDecimal("0.25");
                BigDecimal dimesValue = new BigDecimal("0.1");
                BigDecimal nickelsValue = new BigDecimal("0.05");

                BigDecimal numQuarters = balance.divideAndRemainder(quarterValue)[0];
//                    numQuarters = numQuarters.round();
                BigDecimal quarterRemainder = balance.divideAndRemainder(quarterValue)[1];

                BigInteger numDimes = (quarterRemainder.divideAndRemainder(dimesValue)[0]).toBigInteger();
                BigDecimal dimeRemainder = quarterRemainder.divideAndRemainder(dimesValue)[1];

                BigDecimal numNickels = dimeRemainder.divideAndRemainder(nickelsValue)[0];

                System.out.println("Quarters : " + numQuarters);
                System.out.println("Dimes : " + numDimes);
                System.out.println("Nickels : " + numNickels);

                Logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a ")) + "GIVE CHANGE $" +  buyerAccount.getBalance().toString() + " $0.00");

                break;
            }
        }
    }
}
