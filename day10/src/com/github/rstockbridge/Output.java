package com.github.rstockbridge;

import java.util.ArrayList;
import java.util.List;

class Output implements Recipient {

    private List<Integer> chips = new ArrayList<>();

    int returnFirstChip() {
        return chips.get(0);
    }

    @Override
    public void addChip(int chip) {
        chips.add(chip);
    }
}
