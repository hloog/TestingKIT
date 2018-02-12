package edu.kit.informatik;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    public static void log(String message) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);
            out.write(message + "\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}