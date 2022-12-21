package org.example.console_app.runners;

import org.example.console_app.dto.CommandDto;
import org.example.console_app.runners.utils.CommandUtils;
import org.example.console_app.service.shop.ShopService;
import org.example.console_app.service.shop.api.IShopService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FromFileToFileRunner {
    private final Scanner scn;
    private final IShopService service;

    public FromFileToFileRunner() {
        this.service = new ShopService();
        this.scn = new Scanner(System.in);
    }

    public void run() throws IOException {
        System.out.println("Enter Absolute Path of Command File | Examples: 'absolutePath' or 'absolutePath' card-1234");

        Path fromPath = Path.of(scn.nextLine());

        Path resultPath = Path.of("src", "main", "resources", "ResultReceipt");

        String command = Files.readString(fromPath);
        CommandDto commandDto = CommandUtils.parseCommand(command);

        String receipt = commandDto.getCardNumber() != null ?
                         service.getReceipt(commandDto.getIdAndCountMap(), commandDto.getCardNumber()) :
                         service.getReceipt(commandDto.getIdAndCountMap());

        Files.writeString(resultPath, receipt);
    }
}
