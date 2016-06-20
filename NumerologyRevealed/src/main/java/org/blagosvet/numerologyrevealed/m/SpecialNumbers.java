package org.blagosvet.numerologyrevealed.m;

/**
 *
 * @author dmitri
 */
public class SpecialNumbers {

    private final static int TRINITY_NUMBER = 33;
    private final static int[] POWER_NUMBERS = {22, 11};
    private final static int[] KARMIC_NUMBERS = {13, 15, 16, 19};

    public SpecialNumbers() {
    }
    /**
     * Get Trinity Power number
     *
     * @return Trinity number
     */
    public static int getTrinityNumber() {
        return TRINITY_NUMBER;
    }

    /**
     * Get all Power numbers
     *
     * @return int[] of special numbers
     */
    public static int[] getPowerNumbers() {
        return POWER_NUMBERS;
    }

    /**
     * Get all Karmic numbers
     *
     * @return int[] of special numbers
     */
    public static int[] getKarmicNumbers() {
        return KARMIC_NUMBERS;
    }
    
    /**
     * is number contain a power number
     * 
     * @param number to check for
     * 
     * @return int[] of special numbers
     */
    public static boolean containsAPowerNumber(int number) {
        for (int d : POWER_NUMBERS) {
            if (number == d) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAKarmicNumber(int number) {
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
    public static boolean isPowerNumber(int number) {
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
    public static boolean isKarmicNumber(int number) {
        for (int n : KARMIC_NUMBERS) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }
}
