package org.blagosvet.numerologyrevealed.v;

/**
 *
 * @author dmitri
 */
import java.util.ArrayList;
import org.apache.commons.collections4.MultiValuedMap;
//import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class PrintPersonalType {

    public PrintPersonalType(MultiValuedMap<Integer, ArrayList<Integer>> mvm) {
        System.out.println("=== Personal Type ===");
        for (int i : mvm.keySet()) {
            System.out.println("Key=" + i + "; Index=" + mvm.get(i));
            //+ "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameSum.get(i)));
        }
    }
}
