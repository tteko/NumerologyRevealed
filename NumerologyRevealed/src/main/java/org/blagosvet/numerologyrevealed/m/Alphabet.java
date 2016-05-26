package org.blagosvet.numerologyrevealed.m;

/**
 *
 * @author dmitri
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Alphabet {

    private final static HashMap<Character, Integer> CHARACTER_MAP = new HashMap<Character, Integer>(85, 1.0f) {
        {
            put('A', 1);
            put('B', 2);
            put('C', 3);
            put('D', 4);
            put('E', 5);
            put('F', 6);
            put('G', 7);
            put('H', 8);
            put('I', 9);
            put('J', 1);
            put('K', 2);
            put('L', 3);
            put('M', 4);
            put('N', 5);
            put('O', 6);
            put('P', 7);
            put('Q', 8);
            put('R', 9);
            put('S', 1);
            put('T', 2);
            put('U', 3);
            put('V', 4);
            put('W', 5);
            put('X', 6);
            put('Y', 7);
            put('Z', 8);
            // SPECIAL SPANISH
            put('Ñ', 1); // Spanish 'Ñ' is translated to latin 'NN'; 5+5=10=1

            // RUSSIAN/BULGARIAN
            put('А', 1);
            put('Б', 2);
            put('В', 4);
            put('Г', 7);
            put('Д', 4);
            put('Е', 5);
            put('Ё', 6);
            put('Ж', 1);
            put('З', 8);
            put('И', 9);
            put('Й', 9);
            put('К', 2);
            put('Л', 3);
            put('М', 4);
            put('Н', 5);
            put('О', 6);
            put('П', 7);
            put('Р', 9);
            put('С', 1);
            put('Т', 2);
            put('У', 3);
            put('Ф', 6);
            put('Х', 8);
            put('Ц', 3);
            put('Ч', 3);
            put('Ш', 1);
            put('Щ', 2);
            put('Ъ', 0);
            put('Ы', 8);
            put('Ь', 0);
            put('Э', 5);
            put('Ю', 4);
            put('Я', 7);

            // GREEK
            put('Α', 1);
            put('Β', 2);
            put('Γ', 7);
            put('Δ', 4);
            put('Ε', 5);
            put('Ζ', 8);
            put('Η', 5);
            put('Θ', 4);
            put('Ι', 9);
            put('Κ', 2);
            put('Λ', 3);
            put('Μ', 4);
            put('Ν', 5);
            put('Ξ', 1);
            put('Ο', 6);
            put('Π', 7);
            put('Ρ', 9);
            put('Σ', 1);
            put('Τ', 2);
            put('Υ', 3);
            put('Χ', 3);
            put('Ψ', 8);
            put('Ω', 6);

            //put(' ', 0);
        }
    ;
    };

    private final static HashMap<Character, Integer> CONSTANT_MAP = new HashMap<Character, Integer>(62, 1.0f) {
        {
            put('B', 2);
            put('C', 3);
            put('D', 4);
            put('F', 6);
            put('G', 7);
            put('H', 8);
            put('J', 1);
            put('K', 2);
            put('L', 3);
            put('M', 4);
            put('N', 5);
            put('P', 7);
            put('Q', 8);
            put('R', 9);
            put('S', 1);
            put('T', 2);
            put('V', 4);
            put('W', 5);
            put('X', 6);
            put('Z', 8);
            // SPECIAL SPANISH
            put('Ñ', 1); // Spanish 'Ñ' is translated to latin 'NN'; 5+5=10=1

            // RUSSIAN/BULGARIAN
            put('Б', 2);
            put('В', 4);
            put('Г', 7);
            put('Д', 4);
            put('Ж', 1);
            put('З', 8);
            put('Й', 9);
            put('К', 2);
            put('Л', 3);
            put('М', 4);
            put('Н', 5);
            put('П', 7);
            put('Р', 9);
            put('С', 1);
            put('Т', 2);
            put('Ф', 6);
            put('Х', 8);
            put('Ц', 3);
            put('Ч', 3);
            put('Ш', 1);
            put('Щ', 2);
            put('Ъ', 0);
            put('Ь', 0);

            // GREEK
            put('Β', 2);
            put('Γ', 7);
            put('Δ', 4);
            put('Ζ', 8);
            put('Η', 5);
            put('Θ', 4);
            put('Κ', 2);
            put('Λ', 3);
            put('Μ', 4);
            put('Ν', 5);
            put('Ξ', 1);
            put('Π', 7);
            put('Ρ', 9);
            put('Σ', 1);
            put('Τ', 2);
            put('Χ', 3);
            put('Ψ', 8);

            //put(' ', 0);
        }
    ;
    };

    private final static HashMap<Character, Integer> VOWEL_MAP = new HashMap<Character, Integer>(23, 1.0f) {
        {
            put('A', 1);
            put('E', 5);
            put('I', 9);
            put('O', 6);
            put('U', 3);
            put('Y', 7);

            // RUSSIAN/BULGARIAN
            put('А', 1);
            put('Е', 5);
            put('Ё', 6);
            put('И', 9);
            put('О', 6);
            put('У', 3);
            put('Ы', 8);
            put('Э', 5);
            put('Ю', 4);
            put('Я', 7);

            // GREEK
            put('Α', 1);
            put('Ε', 5);
            put('Ι', 9);
            put('Ο', 6);
            put('Υ', 3);
            put('Ω', 6);

            //put(' ', 0);
        }
    ;

    };

    public Alphabet() {
    }

    /**
     * get Set of vowels
     *
     * @return HashMap of vowels
     */
    public HashMap<Character, Integer> getVowelMap() {
        return VOWEL_MAP;
    }

    /**
     * get Set of consonants
     *
     * @return HashMap of consonants
     */
    public HashMap<Character, Integer> getConsonantMap() {
        return CONSTANT_MAP;
    }

    /**
     * get Map of all characters: vowels and consonants
     *
     * @return HashMap of characters
     */
    public HashMap<Character, Integer> getCharacterMap() {
        return CHARACTER_MAP;
    }

    /**
     * Translate consonant String to ArrayList of integer digits
     *
     * @param text is String of consonant characters
     * @return ArrayList of digits
     */
    public ArrayList<Integer> getConsonantDigits(String text) {

        ArrayList<Integer> digits = new ArrayList<>();

        for (char c : text.toUpperCase().toCharArray()) {
            if (CONSTANT_MAP.containsKey(c)) {
                digits.add(CONSTANT_MAP.get(c));
            } else {
                digits.add(0);
            }
        }

        return digits;
    }

    /**
     * Translate vowel String to ArrayList of integer digits
     *
     * @param text is String of vowel characters
     * @return ArrayList of digits
     */
    public ArrayList<Integer> getVowelDigits(String text) {

        ArrayList<Integer> digits = new ArrayList<>();

        for (char c : text.toUpperCase().toCharArray()) {
            if (VOWEL_MAP.containsKey(c)) {
                digits.add(VOWEL_MAP.get(c));
            } else {
                digits.add(0);
            }
        }
        return digits;
    }
}
