public class GiveInstruction implements Instruction {
    int givingBotNumber;
    String lowRecipientType;
    int lowRecipientNumber;
    String highRecipientType;
    int highRecipientNumber;

    @Override
    public void parseInputData(String inputData) {
        String[] parsedInputData = inputData.split(" ");
        givingBotNumber = Integer.parseInt(parsedInputData[1]);
        lowRecipientType = parsedInputData[5];
        lowRecipientNumber = Integer.parseInt(parsedInputData[6]);
        highRecipientType = parsedInputData[10];
        highRecipientNumber = Integer.parseInt(parsedInputData[11]);
    }
}
