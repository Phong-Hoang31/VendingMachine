package com.techelevator;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseMenu {

    public void purchaseMenu(VendingMachine vendingMachine, BuyerAccount buyerAccount) {

        Scanner userInput = new Scanner(System.in);

        while (true) {
            NumberFormat formatter = new DecimalFormat("#0.00");

            System.out.printf("Current Money Provided: $%s", formatter.format(buyerAccount.getBalance()) + "\n");

            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction\n");

            String input = userInput.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter a whole dollar amount: \n");

                BigDecimal dollarAmount = new BigDecimal(userInput.nextLine());
                Logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a ")) + "FEED MONEY: $" + buyerAccount.getBalance().toString() + " $" + dollarAmount);
                buyerAccount.setBalance(buyerAccount.getBalance().add(dollarAmount));
            }

            if (input.equals("2")) {
                vendingMachine.showInventory();
                System.out.println("Enter a valid code: \n");

                String slotName = userInput.nextLine();

                // Buyer tries to purchase an item
                buyerAccount.setBalance(vendingMachine.purchaseItem(buyerAccount.getBalance(), slotName));
            }
            if (input.equals("3")) {
                BigDecimal[] change = getChange(buyerAccount);
                NumberFormat integerFormatter = new DecimalFormat("#0");
                System.out.println("Quarters : " + integerFormatter.format(change[0]));
                System.out.println("Dimes : " + integerFormatter.format(change[1]));
                System.out.println("Nickels : " + integerFormatter.format(change[2]) + "\n");


                break;
            }
        }
    }

    public BigDecimal[] getChange(BuyerAccount buyerAccount) {
        BigDecimal balance = buyerAccount.getBalance();

        BigDecimal quarterValue = new BigDecimal("0.25");
        BigDecimal dimesValue = new BigDecimal("0.1");
        BigDecimal nickelsValue = new BigDecimal("0.05");

        BigDecimal[] change = new BigDecimal[3];
        BigDecimal numQuarters = balance.divideAndRemainder(quarterValue)[0];
//                    numQuarters = numQuarters.round();
        BigDecimal quarterRemainder = balance.divideAndRemainder(quarterValue)[1];

        BigDecimal numDimes = quarterRemainder.divideAndRemainder(dimesValue)[0];
        BigDecimal dimeRemainder = quarterRemainder.divideAndRemainder(dimesValue)[1];

        BigDecimal numNickels = dimeRemainder.divideAndRemainder(nickelsValue)[0];
        change[0] = numQuarters;
        change[1] = numDimes;
        change[2] = numNickels;


        Logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a ")) + "GIVE CHANGE: $" + buyerAccount.getBalance().toString() + " $0.00");
        return change;
    }
}

