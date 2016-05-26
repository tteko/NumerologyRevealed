package org.blagosvet.numerologyrevealed.m;

/**
 *
 * @author dmitri
 */
public class SpecialNumbers {

    private final static int[] POWER_NUMBERS = {33, 22, 11};
    private final static int[] KARMIC_NUMBERS = {13, 15, 16, 19};

    public SpecialNumbers() {
    }

    /**
     * Get all Power numbers
     *
     * @return int[] of special numbers
     */
    public int[] getPowerNumbers() {
        return POWER_NUMBERS;
    }

    /**
     * Get all Karmic numbers
     *
     * @return int[] of special numbers
     */
    public int[] getKarmicNumbers() {
        return KARMIC_NUMBERS;
    }

    public boolean containsAPowerNumber(int number) {
        for (int d : POWER_NUMBERS) {
            if (number == d) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAKarmicNumber(int number) {
        for (int d : KARMIC_NUMBERS) {
            if (number == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test a number for a Power number
     *
     * @param number to test
     * @return true if number is a Power Number, else return false
     */
    public boolean isPowerNumber(int number) {
        for (int n : POWER_NUMBERS) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test a number for a Karmic number
     *
     * @param number to test
     * @return true if number is a Karmic Number, else return false
     */
    public boolean isKarmicNumber(int number) {
        for (int n : KARMIC_NUMBERS) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }
}
