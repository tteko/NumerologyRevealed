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
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.StringUtils;

public class Computation {

    //// Alphabet
    private Alphabet alphabet = null;
    private HashMap<Character, Integer> characterMap = null;
    private HashMap<Character, Integer> vowelMap = null;
    private HashMap<Character, Integer> consonantMap = null;

    //// SpecialNumbers
    //private SpecialNumbers specialNumbers = null;
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

    // ===== Result of calculation contains in ArrayDeque
    private ArrayDeque<String> result;

    public Computation(Person person) {

        ////=== Result of computation
        result = new ArrayDeque<>();

        ////=== Alphabet
        alphabet = new Alphabet();
        characterMap = alphabet.getCharacterMap();
        vowelMap = alphabet.getVowelMap();
        consonantMap = alphabet.getConsonantMap();

        ////==  Personality Type (Consonants)
        ///// Last name
        //////  digits
        pTypeLastNameDigits = alphabet.getConsonantDigits(person.getLastName());
        //////  sum
        pTypeLastNameSum = new ArrayListValuedHashMap<>();
        //////  index
        ArrayList<Integer> pTypeLastNameIndex = getIndex(pTypeLastNameDigits);
        // Peterson, digits: [7, 0, 2, 0, 9, 1, 0, 5] Index: [0, 2, 4, 5, 7]

        ////======= T E S T S =======
        //// Person
        //+System.out.println(person);
        //// Selection
        System.out.println(person.getLastName() + "\nDigits:" + pTypeLastNameDigits
                + "\nIndex :" + pTypeLastNameIndex);
        //==>

        result.add(insertCharacter(person.getLastName(), ' '));
        //result.add(person.getLastName().chars().mapToObj(c -> (char) c).collect(Collectors.joining("+")));
        //result.add(person.getLastName().toCharArray().stream().map(Object::toString)
        //        .collect(Collectors.joining("+")));
        // that below works
        result.add(pTypeLastNameDigits.stream().map(Object::toString)
                .collect(Collectors.joining("+")));

        String lastNameDigits = pTypeLastNameDigits
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        //System.out.println("lastNameDigits="+lastNameDigits);
        result.add(zeroPlus(lastNameDigits));
        System.out.println("==== Search for TRINITY_NUMBER (" + ")");
        int trinityNumber = SpecialNumbers.getTrinityNumber();
        boolean found33 = false;
        int i33 = 0;
        while (i33 < pTypeLastNameIndex.size()) {
            //System.out.println("for i="+i);
            ArrayList<Integer> fprt33 = new ArrayList<>();
            fprt33.add(pTypeLastNameIndex.get(i33));
            found33 = selection(pTypeLastNameDigits, pTypeLastNameIndex, i33, fprt33, trinityNumber);

            if (found33) {
                //System.out.print(" Found!");
                System.out.println(" In Reminder:\n  Digits are " 
                        + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex) 
                        + "\n  Index is " + pTypeLastNameIndex);
                int currsum = summarize(pTypeLastNameDigits, pTypeLastNameIndex);
                //System.out.println(" Currsumm=" + currsum + "; trinityNumber=" + trinityNumber + " if(" + currsum + " < " + trinityNumber + ")break;");
                //System.out.println(" i=" + i33 + "; pTypeLastNameIndex.size()=" + pTypeLastNameIndex.size());
                if (currsum < trinityNumber) {
                    break;
                }
            } else {
                i33++;
            }
        }
        System.out.print("\nRESULT: ");
        if (found33) {
            System.out.println("Found " + trinityNumber + ":");
            System.out.println("Reminder:\n Digits are " 
                    + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex) 
                    + "\n Index is " + pTypeLastNameIndex);
        } else {
            System.out.println(trinityNumber + " was not found!");
        }
        System.out.println("\nResult of selection:");
        for (int i : pTypeLastNameSum.keySet()) {
            System.out.println("Key=" + i + "; Index=" + pTypeLastNameSum.get(i));
            //+ "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameSum.get(i)));
        }
        System.out.println(" Reminder is " + pTypeLastNameIndex + "; " 
                + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
        //==== Prepare of 33 -> (3+3) = 6 
        
        //==== Search for 22 and 11 ===="
        /*     for (int powerNumber : SpecialNumbers.getPowerNumbers()) {
            //for (int powerNumber : specialNumbers.getPowerNumbers()) {
            System.out.println("\n==== Search for " + powerNumber + " ====");
            boolean found = false;
            int i = 0;
            while (i < pTypeLastNameIndex.size()) {
                //System.out.println("for i="+i);
                ArrayList<Integer> fprt = new ArrayList<>();
                fprt.add(pTypeLastNameIndex.get(i));
                found = selection(pTypeLastNameDigits, pTypeLastNameIndex, i, fprt, powerNumber);

                if (found) {
                    //System.out.print(" Found!");
                    System.out.println(" In Reminder:\n  Digits are " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex) + "\n  Index is " + pTypeLastNameIndex);
                    int currsum = summarize(pTypeLastNameDigits, pTypeLastNameIndex);
                    System.out.println(" Currsumm=" + currsum + "; powerNumber=" + powerNumber + " if(" + currsum + " < " + powerNumber + ")break;");
                    System.out.println(" i=" + i + "; pTypeLastNameIndex.size()=" + pTypeLastNameIndex.size());
                    if (currsum < powerNumber) {
                        break;
                    }
                } else {
                    i++;
                }
            }
            System.out.print("\nRESULT: ");
            if (found) {
                System.out.println("Found " + powerNumber + ":");
                System.out.println("Reminder:\n Digits are " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex) + "\n Index is " + pTypeLastNameIndex);
            } else {
                System.out.println(powerNumber + " was not found!");
            }
        }
        ////
        
        //for (Map.Entry entry : pTypeLastNameSum.entrySet()) {
        //    System.out.println(entry.getKey() + ": " + entry.getValue() + "; " + getDigitsFromIndex(pTypeLastNameDigits, (ArrayList)entry.getValue()));
        //}
        //System.out.println("Reminder is " + pTypeLastNameIndex + "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameIndex));
         */
        for (String s : result) {
            System.out.println(s);
        }
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
     *
     * @return boolean, true if checksum was found
     */
    private boolean selection(
            ArrayList<Integer> src,
            ArrayList<Integer> ind,
            int position,
            ArrayList<Integer> forepart,
            int checknum) {
        boolean ret = false;
        //System.out.println("\nselection(" + src + "," + ind + "," + position + "," + forepart + "," + checknum + ");");
        for (int j = position + 1; j < ind.size(); j++) {
            ArrayList<Integer> part = new ArrayList<>(forepart);
            part.add(ind.get(j));
            //System.out.println(part);
            int summ = summarize(src, part);

            if (summ == checknum) {
                System.out.println(" selection(): " + checknum + " is found:\n\tDigits are " + getDigitsFromIndex(src, part) + "\n\tIndex is " + part);
                pTypeLastNameSum.put(summ, part);
                ind.removeAll(part);
                System.out.println(" selection(): Reminder:\n\tDigits are " + getDigitsFromIndex(src, ind) + "\n\tIndex is " + ind);
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
     * @param digits is ArrayList of digits
     * @param index is ArrayList of index
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
     * @param digits is ArrayList of digits
     * @param index is ArrayList of index
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
     * @param digits is ArrayList of digits
     * @param index is ArrayList of index
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

    /**
     * Result of computation
     *
     * @return result of computation
     */
    public ArrayDeque<String> getResult() {
        return result;
    }

    /**
     * Insert a character between characters of given string
     *
     * @param line is String to tranform
     * @param addon is character to insert between
     *
     * @return String transformed
     */
    private String insertCharacter(String line, char addon) {
        StringBuilder sb = new StringBuilder();
        int length = line.length();
        for (int i = 0; i < length; i++) {
            sb.append(line.charAt(i));
            if (i < (length - 1)) {
                sb.append(addon);
            }
        }
        return sb.toString();
    }

    /**
     * Clean String of digits, delete zero(-es) and add +
     *
     * @param line is String to clean
     *
     * @return String
     */
    private String zeroPlus(String line) {
        StringBuffer ret = new StringBuffer();
        Pattern pattern = Pattern.compile("0+");
        Matcher matcher = pattern.matcher(line);

        String[] ar = pattern.split(line);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].length() > 1) {
                int ar_size = ar[i].length();
                for (int j = 0; j < ar_size; j++) {
                    ret.append(ar[i].charAt(j));
                    if (j < (ar_size - 1)) {
                        ret.append("+");
                    }
                }
            } else {
                ret.append(ar[i]);
            }

            String found;
            if (matcher.find()) {
                found = matcher.group();
                int s_length = found.length();

                if (i > 0 && i < (ar.length - 1)) {
                    ret.append(StringUtils.center("+", 1 + (s_length * 2)));
                } else if (ar[i].length() >= 1) {
                    ret.append(StringUtils.center("+", 1 + (s_length * 2)));
                } else {
                    ret.append(StringUtils.center(" ", s_length * 2));
                }
            }
        }
        return ret.toString();
    }
}
