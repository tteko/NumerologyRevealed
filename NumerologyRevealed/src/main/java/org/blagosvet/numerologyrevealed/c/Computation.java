package org.blagosvet.numerologyrevealed.c;

/**
 *
 * @author dmitri
 */
import org.blagosvet.numerologyrevealed.m.Alphabet;
import org.blagosvet.numerologyrevealed.m.SpecialNumbers;
import org.blagosvet.numerologyrevealed.m.Person;

import java.util.HashMap;
import java.util.ArrayList;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class Computation {
    
    //// Alphabet
    private Alphabet alphabet = null;
    private HashMap<Character, Integer> characterMap = null;
    private HashMap<Character, Integer> vowelMap = null;
    private HashMap<Character, Integer> consonantMap = null;

    //// SpecialNumbers
    private SpecialNumbers specialNumbers = null;

    //// Personality Type (Consonants)
    //private ArrayList<Integer> pTypeFirstNameDigits;
    //private ArrayList<Integer> pTypeMiddleNameDigits;
    private ArrayList<Integer> pTypeLastNameDigits;
    //private HashMap<Integer, ArrayList<Integer>> pTypeLastNameSum;
    //private ArrayList<ArrayList<Integer>> pTypeLastNameSum;
    private MultiValuedMap<Integer, ArrayList<Integer>> pTypeLastNameSum;
    //// Soul Urge (Vowels)
    //private ArrayList<Integer> sUrgeFirstNameDigits;
    //private ArrayList<Integer> sUrgeMiddleNameDigits;
    //private ArrayList<Integer> sUrgeLastNameDigits;

    public Computation(Person person) {

        //// Alphabet
        alphabet = new Alphabet();
        characterMap = alphabet.getCharacterMap();
        vowelMap = alphabet.getVowelMap();
        consonantMap = alphabet.getConsonantMap();

        //// SpecialNumbers
        specialNumbers = new SpecialNumbers();

        //// Personality Type (Consonants)
        // personal type last name digits
        pTypeLastNameDigits = alphabet.getConsonantDigits(person.getLastName());
        // personal type last name sum
        pTypeLastNameSum = new ArrayListValuedHashMap<>();
        // personal type last name index
        ArrayList<Integer> pTypeLastNameIndex = getIndex(pTypeLastNameDigits);
        // Peterson, digits: [7, 0, 2, 0, 9, 1, 0, 5] Index: [0, 2, 4, 5, 7]

        ////======= T E S T S =======
        //// Person
        //+System.out.println(person);
        //// Selection
        System.out.println(person.getLastName() + " " + pTypeLastNameDigits
                + " Index: " + pTypeLastNameIndex);
        for (int n : specialNumbers.getPowerNumbers()) {
            System.out.print("\nSearch for " + n + ":");
            boolean found = false;
            int i = 0;
            while (i < pTypeLastNameIndex.size()) {
                //System.out.println("for i="+i);
                ArrayList<Integer> fprt = new ArrayList<>();
                fprt.add(pTypeLastNameIndex.get(i));
                found = selection(pTypeLastNameDigits, pTypeLastNameIndex, i, fprt, n);

                if (found) {
                    //System.out.print(" Found!");
                    System.out.println("in Reminder is " + pTypeLastNameIndex + "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
                    int currsum = summarize(pTypeLastNameDigits, pTypeLastNameIndex);
                    System.out.println("Currsumm=" + currsum + "; n=" + n + " if(" + currsum + " < " + n + ")break;");
                    System.out.println("i=" + i + "; pTypeLastNameIndex.size()=" + pTypeLastNameIndex.size());
                    if (currsum < n) {
                        break;
                    }
                } else {
                    i++;
                }
            }
            if (found) {
                System.out.print(" Found!");
                System.out.println(" Reminder is " + pTypeLastNameIndex + "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
            } else {
                System.out.println(" Not found!");
            }
        }
        ////
        System.out.println("\nResult of selection:");
        for (int i : pTypeLastNameSum.keySet()) {
            System.out.println("Key=" + i + "; Index=" + pTypeLastNameSum.get(i));
            //+ "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameSum.get(i)));
        }
        System.out.println(" Reminder is " + pTypeLastNameIndex + "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
        //for (Map.Entry entry : pTypeLastNameSum.entrySet()) {
        //    System.out.println(entry.getKey() + ": " + entry.getValue() + "; " + getDigitsFromIndex(pTypeLastNameDigits, (ArrayList)entry.getValue()));
        //}
        //System.out.println("Reminder is " + pTypeLastNameIndex + "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
    } //Constructor

    /**
     * Make a selection
     *
     * @param src is ArrayList of index
     * @param ind is the start position in index
     * @param position of foreart of index
     * @param checknum is number to check
     *
     * Class level variables: pTypeLastNameSum
     * @return boolean, true if checksum was found
     */
    private boolean selection(ArrayList<Integer> src, ArrayList<Integer> ind, int position, ArrayList<Integer> forepart, int checknum) {
        boolean ret = false;
        //System.out.println("\nselection(" + src + "," + ind + "," + position + "," + forepart + "," + checknum + ");");
        for (int j = position + 1; j < ind.size(); j++) {
            ArrayList<Integer> part = new ArrayList<>(forepart);
            part.add(ind.get(j));
            //System.out.println(part);
            int s = summarize(src, part);

            if (s == checknum) {
                System.out.print(" Checknum!: " + checknum + ": " + getDigitsFromIndex(src, part) + "; " + part);
                pTypeLastNameSum.put(s, part);
                ind.removeAll(part);
                System.out.println(" Reminder: " + getDigitsFromIndex(src, ind) + "; " + ind);
                ret = true;
                break;
            } else {
                //boolean reti = false;
                if (part.size() <= ind.size()) {
                    ret = selection(src, ind, j, part, checknum);
                }

                if (ret) {
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * Get index of actual digits, 0 will be passed
     *
     * @param digit is ArrayList of digits
     *
     * @return ArrayList of index
     */
    private ArrayList<Integer> getIndex(ArrayList<Integer> digit) {
        int i = 0;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int n : digit) {
            if (n != 0) {
                ret.add(i);
            }
            ++i;
        }
        return ret;
    }

    /**
     * Get index of actual digits, 0 will be passed
     *
     * @param ArrayList of digits
     *
     * @return ArrayList of index
     */
    private ArrayList<Integer> getDigitsFromIndex(ArrayList<Integer> digits, ArrayList<Integer> index) {

        ArrayList<Integer> reminder = new ArrayList<>();

        for (int i : index) {
            reminder.add(digits.get(i));
        }

        return reminder;
    }

    /**
     * Delete digits according to index
     *
     * @param ArrayList of digits
     * @param ArrayList of index
     */
    private void deleteDigits(ArrayList<Integer> digits, ArrayList<Integer> index) {

        int shift = 0;

        for (int i = 0; i < index.size(); i++) {
            digits.remove(index.get(i) + (shift--));
        }

    }

    /**
     * Calculate sum of digits
     *
     * @param ArrayList of digits
     *
     * @return Sum of digits
     */
    private int summarize(ArrayList<Integer> digits, ArrayList<Integer> index) {
        int sum = 0;
        for (int i = 0; i < index.size(); i++) {
            sum = sum + digits.get(index.get(i));
        }
        return sum;
    }
}
