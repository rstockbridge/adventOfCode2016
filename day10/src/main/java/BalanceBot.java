class BalanceBot implements Recipient {

    private Integer low;
    private Integer high;

    BalanceBot() {
    }

    BalanceBot(int inputLow) {
        low = inputLow;
    }

    int getLow() {
        return low;
    }

    int getHigh() {
        return high;
    }

    int getNumberOfChips() {
        if (low == null && high == null) {
            return 0;
        } else if (low != null && high == null) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void addChip(int inputValue) {
        if (getNumberOfChips() == 0) {
            low = inputValue;
        } else if (inputValue < low) {
            high = low;
            low = inputValue;
        } else {
            high = inputValue;
        }
    }

    void removeChips() {
        low = null;
        high = null;
    }
}


