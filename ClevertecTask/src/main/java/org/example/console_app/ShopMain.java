package org.example.console_app;


import org.example.console_app.runners.ConsoleRunner;
import org.example.console_app.runners.FromFileToFileRunner;

import java.io.IOException;

public class ShopMain {
    public static void main(String[] args) {
        ConsoleRunner consoleRunner = new ConsoleRunner();
        FromFileToFileRunner fromFileToFileRunner = new FromFileToFileRunner();

        consoleRunner.run();
//        try {
//            fromFileToFileRunner.run();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}