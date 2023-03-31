package com.example.devcopassignment;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegularAmount {

    @NotNull
    private Frequency frequency;

    @NotNull
    @DivisibleByOneWeek
    @DecimalMin(value = "0", message = "Amount must be a positive number")
    private String amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

enum Frequency{
    WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR;
}
