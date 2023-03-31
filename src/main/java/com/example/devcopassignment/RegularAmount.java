package com.example.devcopassignment;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class RegularAmount {

    @NotNull(message = "Frequency cannot be null")
    private Frequency frequency;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    @Digits(integer = 10, fraction = 2, message = "Amount must have at most 10 integer digits and 2 fraction digits")
    @DivisibleByOneWeek(message = "Amount must be divisible by one week's worth of pence for the selected frequency")
    private BigDecimal amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

enum Frequency{
    WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR;
}
