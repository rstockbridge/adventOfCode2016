package com.github.rstockbridge;

public class GiveInstruction implements Instruction {
    int givingBotNumber;
    String lowReceiverType;
    int lowRecipientNumber;
    String highReceiverType;
    int highReceiverNumber;

    @Override
    public void parseInputData(String inputData) {
        String[] parsedInputData = inputData.split(" ");
        givingBotNumber = Integer.parseInt(parsedInputData[1]);
        lowReceiverType = parsedInputData[5];
        lowRecipientNumber = Integer.parseInt(parsedInputData[6]);
        highReceiverType = parsedInputData[10];
        highReceiverNumber = Integer.parseInt(parsedInputData[11]);
    }
}
