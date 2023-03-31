package com.example.devcopassignment;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisibleByWeekValidator implements ConstraintValidator<DivisibleByOneWeek, RegularAmount> {

    //private int numberOfWeeks;

    @Override
    public void initialize(DivisibleByOneWeek constraintAnnotation) {
        // this.numberOfWeeks  = constraintAnnotation.numberOfWeeks();
    }

    @Override
    public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext context) {
        if (regularAmount == null || regularAmount.getFrequency() == null) {
            return true;
        }

        //check if frequency is a multiple of a week
        Frequency frequency = regularAmount.getFrequency();
        String amount = regularAmount.getAmount();
        if (amount == null || amount.isEmpty()) {
            return true;
        }



        BigDecimal weeklyAmount = null;
        int weeks = 1;

        switch (frequency) {
            case WEEK:
                weeklyAmount = new BigDecimal(amount);
                break;

            case TWO_WEEK:
                weeks = 2;
                break;

            case FOUR_WEEK:
                weeks = 4;
                break;

            case MONTH:
                return true; //Monthly cannot be divided into weekly amounts

            case QUARTER:
                weeks = 13;
                break;

            case YEAR:
                weeks = 52;
                break;
            default:
                throw new IllegalArgumentException("Unknown frequency: " + frequency);
        }

        if (weeklyAmount == null) {
            //Calculate the weekly amount if needed
            BigDecimal totalAmount = new BigDecimal(amount);
            weeklyAmount = totalAmount.divide(new BigDecimal(weeks), 2, RoundingMode.DOWN);
        }

        BigDecimal weeklyPence = weeklyAmount.multiply(new BigDecimal("100")).setScale(0, RoundingMode.DOWN);

        //Checking if the weekly amount is a whole number of pence
        return weeklyAmount.multiply(new BigDecimal(100)).remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}





