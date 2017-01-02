package com.github.rstockbridge;

public class ValueInstruction implements Instruction {
    int chip;
    int botToReceiveChip;


    @Override
    public void parseInputData(String inputData) {
        String[] parsedInputData = inputData.split(" ");
        chip = Integer.parseInt(parsedInputData[1]);
        botToReceiveChip = Integer.parseInt(parsedInputData[5]);
    }
}

