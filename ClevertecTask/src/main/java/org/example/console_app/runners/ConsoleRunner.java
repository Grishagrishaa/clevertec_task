package org.example.console_app.runners;

import org.example.console_app.dto.CommandDto;
import org.example.console_app.runners.utils.CommandUtils;
import org.example.console_app.service.shop.ShopService;
import org.example.console_app.service.shop.api.IShopService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleRunner {
    private final Scanner scn;
    private final IShopService service;

    public ConsoleRunner() {
        this.scn = new Scanner(System.in);
        this.service = new ShopService();
    }

    public void run(){//3-1 2-5 5-1 card-1234
        System.out.println("Enter command | Examples: 1-1 2-1 3-1 or 1-1 2-1 3-1 card-1234");
        String command = scn.nextLine();

        CommandDto commandDto = CommandUtils.parseCommand(command);

        String receipt = commandDto.getCardNumber() != null ?
                service.getReceipt(commandDto.getIdAndCountMap(), commandDto.getCardNumber()) :
                service.getReceipt(commandDto.getIdAndCountMap());

        System.out.println(receipt);
    }
}

