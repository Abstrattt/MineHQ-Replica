package com.frozenorb.commonlibs.utils;

public class MathsUtility {

    /**
     *
     *
     * @param input
     * @param min
     * @param max
     * @return
     */
    public static Boolean isBetween(Integer input, Integer min, Integer max){
        return input >= min && input <= max;
    }

    /**
     *
     *
     * @param input
     * @return
     */
    public static int convertToPositive(int input){
        if (input > 0){
            return input;
        }
        return Math.abs(input);
    }

}
