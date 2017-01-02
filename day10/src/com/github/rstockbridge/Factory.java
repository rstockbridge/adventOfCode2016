package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Factory {
    private List<ValueInstruction> storedValueInstructions;
    private List<GiveInstruction> storedGiveInstructions;
    private Map<Integer, BalanceBot> allBots;
    Map<Integer, Output> allOutput;

    Factory() {
        allBots = new HashMap<>();
        allOutput = new HashMap<>();
        storedValueInstructions = new ArrayList<>();
        storedGiveInstructions = new ArrayList<>();
    }

    void initialize() {
        parseInputData();
        populateFactory();
    }

    private void parseInputData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/Dropbox/" +
                "documents/coding/adventOfCode2016/day10/src/com/github/rstockbridge/input.txt"))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                if (line.contains("value")) {
                    ValueInstruction valueInstruction = new ValueInstruction();
                    valueInstruction.parseInputData(line);
                    storedValueInstructions.add(valueInstruction);
                } else {
                    GiveInstruction giveInstruction = new GiveInstruction();
                    giveInstruction.parseInputData(line);
                    storedGiveInstructions.add(giveInstruction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateFactory() {
        for (ValueInstruction valueInstruction : storedValueInstructions) {
            if (!allBots.containsKey(valueInstruction.botToReceiveChip)) {
                allBots.put(valueInstruction.botToReceiveChip, new BalanceBot(valueInstruction.chip));
            } else {
                allBots.get(valueInstruction.botToReceiveChip).addChip(valueInstruction.chip);
            }
        }

        for (GiveInstruction giveInstruction : storedGiveInstructions) {
            if (!allBots.containsKey(giveInstruction.givingBotNumber)) {
                allBots.put(giveInstruction.givingBotNumber, new BalanceBot());
            }
        }
    }

    void run() {
        while (storedGiveInstructions.size() > 0) {
            GiveInstruction activeGiveInstruction = new GiveInstruction();

            for (GiveInstruction giveInstruction : storedGiveInstructions) {
                if (allBots.get(giveInstruction.givingBotNumber).getNumberOfChips() == 2) {
                    activeGiveInstruction = giveInstruction;
                }
            }
            BalanceBot giver = allBots.get(activeGiveInstruction.givingBotNumber);

            if (giver.getLow() == 17 && giver.getHigh() == 61) {
                System.out.format("Bot %d compares value-61 microchips with value-17 microchips.\n", activeGiveInstruction.givingBotNumber);
            }

            int lowChipToBeDistributed = giver.getLow();
            int highChipToBeDistributed = giver.getHigh();
            giver.removeChips();

            distributeChip(lowChipToBeDistributed, getRecipient(activeGiveInstruction, true));
            distributeChip(highChipToBeDistributed, getRecipient(activeGiveInstruction, false));

            storedGiveInstructions.remove(activeGiveInstruction);
        }
    }

    private void distributeChip(Integer chip, Recipient recipient) {
        recipient.addChip(chip);
    }

    private Recipient getRecipient(GiveInstruction activeGiveInstruction, boolean isLow) {
        String recipientType = isLow ? activeGiveInstruction.lowRecipientType : activeGiveInstruction.highRecipientType;
        int recipientNumber = isLow ? activeGiveInstruction.lowRecipientNumber : activeGiveInstruction.highRecipientNumber;

        if (recipientType.equals("bot")) {
            return getBalanceBot(recipientNumber, allBots);
        } else {
            return getOutput(recipientNumber, allOutput);
        }
    }

    private BalanceBot getBalanceBot(int number, Map<Integer, BalanceBot> allBots) {
        if (!allBots.containsKey(number)) {
            allBots.put(number, new BalanceBot());
        }
        return allBots.get(number);
    }

    private Output getOutput(int number, Map<Integer, Output> allOutput) {
        if (!allOutput.containsKey(number)) {
            allOutput.put(number, new Output());
        }
        return allOutput.get(number);
    }
}
