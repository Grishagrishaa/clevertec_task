package org.example.console_app.runners.utils;

import org.example.console_app.dto.CommandDto;

import java.util.HashMap;

public final class CommandUtils {
    private CommandUtils() {
    }

    public static CommandDto parseCommand(String command){
        String[] splitCommands = command.split(" ");

        int cardCommandLocation = command.lastIndexOf("card");

        HashMap<Long, Integer> idAndCount = new HashMap<>();

        if(cardCommandLocation != -1){
            String cardCommand = splitCommands[splitCommands.length - 1];
            Long cardNumber = Long.valueOf(cardCommand.split("-")[1]);

            for (int i = 0; i < splitCommands.length - 1; i++) {
                Long key = Long.parseLong(splitCommands[i].split("-")[0]);
                Integer value = Integer.parseInt(splitCommands[i].split("-")[1]);

                idAndCount.put(key, value);
            }
            return CommandDto.Builder.create()
                    .setIdAndCountMap(idAndCount)
                    .setCardNumber(cardNumber)
                    .build();
        }else {
            for (String splitCommand : splitCommands) {
                Long key = Long.parseLong(splitCommand.split("-")[0]);
                Integer value = Integer.parseInt(splitCommand.split("-")[1]);

                idAndCount.put(key, value);
            }
            return CommandDto.Builder.create()
                    .setIdAndCountMap(idAndCount)
                    .build();        }
    }
}
