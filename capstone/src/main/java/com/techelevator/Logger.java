package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    public static void log(String string) {
        File logFile = new File("Log.txt");
        try {
            FileOutputStream fos = new FileOutputStream(logFile, true);
            PrintWriter writer = new PrintWriter(fos);
            writer.println(string);
            writer.flush();
        } catch (FileNotFoundException fnf) {
            System.out.println("Shouldn't happen!");
        }
    }
}
