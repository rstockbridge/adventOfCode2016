public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.initialize();
        factory.run();

        System.out.format("The product of the values of outputs 0, 1, and 2 is %d.\n", factory.allOutput.get(0).returnFirstChip() * factory.allOutput.get(1).returnFirstChip() * factory.allOutput.get(2).returnFirstChip());
    }
}

