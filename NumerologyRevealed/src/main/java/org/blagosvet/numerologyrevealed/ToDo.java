package org.blagosvet.numerologyrevealed;

/**
 *
 * @author dmitri
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections4.ListValuedMap;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import org.apache.commons.lang3.StringUtils;

import org.blagosvet.numerologyrevealed.m.Person;

public class ToDo {

    private ArrayList<Integer> pTypeLastNameDigits;
    private MultiValuedMap<Integer, ArrayList<Integer>> pTypeLastNameSum;

    public ToDo() {
        String message
                = "\n======= To Do =======\n"
                + "\n"
                + "26-MAY-2016 Alphabet.java: check Bulgarian & Spanish maps";
        System.out.println(message);
        Person person = new Person("Святослав", "Дмитриевич", "Безгодов", "АЕБезгоодооовоо", 2010, 2, 15);
        //Person person = new Person("Оксана", "Александровна", "Юлиенко", "ОЮлиенко", 1969, 2, 23);
        //Юлиенко [0, 3, 0, 0, 5, 2, 0] Index: [1, 4, 5]

        String name = person.getSignature();

        //ArrayList<Integer> pTypeName = new ArrayList<>();
        //[2, 0, 8, 7, 0, 4, 0, 4]
        /*
        Заменить все 0+ сначала на пробелы
        Заменить все хвостовые 0+ на пробелы
        Заменить все остальные 0+ на + посередине
         */
 /* int allnums[] = {0, 0, 2, 0, 8, 7, 0, 0, 4, 0, 0, 0, 4, 0, 0};
        StringBuilder sb = new StringBuilder();

        for (int d : allnums) {
            sb.append(d);
        }
        System.out.println("sb: " + sb);
         */
 /*while (matcher.find()) {

            //System.out.println();
            String s = matcher.group();
            int s_length = s.length();
            //int pos=s_length/2;
            //int rest=s_length-pos;
            //System.out.println("len="+s_length+" pos="+pos+" rest="+rest); 
            //String.format("%1$"+length+ "s", string);
            System.out.println("'" + StringUtils.center("+", s_length) + "'");
            //String format ="%1$"+s_length+ "s";
            //System.out.format(format,StringUtils.center("+",s_length));
            //String result = (s_length == 1) ? "+":" ";
            //System.out.println(result); 
            //(1 == 1) ? System.out.println("+"):System.out.println("zzzz+zzz"); 
        }*/
        //  System.out.println("Not Found! " + matcher);
        //String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
        //System.out.format(format, "FirstName", "Init.", "LastName");
        //System.out.format(format,StringUtils.center("Real",10),StringUtils.center("",10),StringUtils.center("Gagnon",20));
//============================
        /*      // 1. Print the name
        for (char c : name.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 2.Print the digits
        int sb_size = sb.length();
        for (int i = 0; i < sb_size; i++) {
            System.out.print(sb.charAt(i));
            if (i < (sb_size - 1)) {
                System.out.print("+");
            }
        }
        System.out.println();

        // 3. Print the digits except zero(-es)
        Pattern pattern = Pattern.compile("0+");
        Matcher matcher = pattern.matcher(sb.toString());

        String[] ar = pattern.split(sb.toString());
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].length() > 1) {
                int ar_size = ar[i].length();
                for (int j = 0; j < ar_size; j++) {
                    System.out.print(ar[i].charAt(j));
                    if (j < (ar_size - 1)) {
                        System.out.print("+");
                    }
                }
            } else {
                System.out.print(ar[i]);
            }
            String found;
            if (matcher.find()) {
                found = matcher.group();
                int s_length = found.length();
                if (i > 0 && i < (ar.length - 1)) {
                    System.out.print(StringUtils.center("+", 1 + (s_length * 2)));
                } else {
                    System.out.print(StringUtils.center(" ", s_length * 2));
                }
            }
        }
        System.out.println();
         */
 /*//ArrayList<String> als = new ArrayList<>();
        //als.add("First line");
        //als.add("Second line");
        //als.add("Third line");
        ArrayDeque<String> aq = new ArrayDeque<>();
        aq.offerFirst("First line");
        aq.offerFirst("Second line");
        aq.offerFirst("Third line");
        
        //for(String line: als){
        //    System.out.println(line);
        //}//
        //for(String line: aq){
        //    System.out.println(line);
        //}
        Booklet booklet = new Booklet(aq);*/
        ////============ Trinity Number 33 ===============
        int[] digits = {7, 0, 2, 0, 9, 8, 1, 0, 5, 6, 7, 0, 5, 5, 0, 4, 0, 0, 3, 8};
        pTypeLastNameDigits = new ArrayList<>();
        for (int i : digits) {
            pTypeLastNameDigits.add(i);
        }

        int[] i1 = {0, 2, 4, 5, 6, 9};
        int[] i2 = {8, 10, 12, 13, 18, 19};
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i : i1) {
            al1.add(i);
        }
        for (int i : i2) {
            al2.add(i);
        }

        pTypeLastNameSum = new ArrayListValuedHashMap<>();
        pTypeLastNameSum.put(33, al1);
        pTypeLastNameSum.put(33, al2);
        System.out.println("\nResult of selection:");
        System.out.println("EXPECT:");
        System.out.println("Key=33; Index=[[0, 2, 4, 5, 6, 9], [8, 10, 12, 13, 18, 19]]");
        for (int i : pTypeLastNameSum.keySet()) {
            System.out.println("Key=" + i + "; Index=" + pTypeLastNameSum.get(i));
            Iterator iterator = pTypeLastNameSum.get(i).iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            //+ "; " + getDigitsFromIndex(pTypeLastNameDigits, pTypeLastNameSum.get(i)));
        }
        /*ListValuedMap<String, String> listValuedMap = new ArrayListValuedHashMap();

        listValuedMap.put("United States", "Washington");

        listValuedMap.put("Canada", "Ottawa");

        listValuedMap.put("Canada", "Ottawa");

        listValuedMap.put("South Africa", "Pretoria");

        listValuedMap.put("South Africa", "Cape Town");

        listValuedMap.put("South Africa", "Bloemfontein");

        System.out.println(listValuedMap);
         */
        String line = "70209810567055040038";
//P   e   t   e   r   h   s   o   n   f   g   e   n   n   a   d   i   i   c   h
//7 + 0 + 2 + 0 + 9 + 8 + 1 + 0 + 5 + 6 + 7 + 0 + 5 + 5 + 0 + 4 + 0 + 0 + 3 + 8
        StringBuilder ret = new StringBuilder();
        Pattern pattern = Pattern.compile("0+");

        boolean found = false;
        if (line.matches("[1-9]+")) { // 0 is not present
            String[] numbers = pattern.split(line);

            System.out.println("MATCHES [1-9]+ !");
            for (int i = 0; i < numbers.length; i++) {

                for (int j = 0; j < numbers[i].length(); j++) {
                    ret.append(numbers[i].charAt(j));
                    if (j < (numbers[i].length() - 1)) {
                        ret.append(" + ");
                    }
                }
            }
        } else if (line.matches("0+")) {
            System.out.println("MATCHES 0+!");
            ret.append("0");

        } else if (line.matches("\\d+")) {
            System.out.println("MATCHES \\d+ !");
            String[] numbers = pattern.split(line);
            Matcher matcher = pattern.matcher(line);
            int i = 0;
            for (; matcher.find(); i++) {
                //found = true;
                String found_null = matcher.group();
                String found_num = numbers[i];
                System.out.println("SRC: num=" + found_num + " null=" + found_null);
                if (found_num.length() == 0) { // starts from 0
                    ret.append(StringUtils.center(" ", found_null.length() + found_null.length() * 3));
                    System.out.print(" IF: num=" + found_num + " length= " + found_num.length());
                    System.out.println(" null=" + found_null + " length= " + found_null.length());
                } else if (i == 0 && found_num.length() > 0) { // start from number, not 0
                    //ret.append(found_num);
                    for (int j = 0; j < numbers[i].length(); j++) {
                        ret.append(numbers[i].charAt(j));
                        if (j < (numbers[i].length() - 1)) {
                            ret.append(" + ");
                        }
                    }
                    if (!matcher.hitEnd()) {
                        ret.append(StringUtils.center("+", found_null.length() + (1 + found_null.length()) * 3));
                    }
                    System.out.print(" ELSE IF: num=" + found_num + " length= " + found_num.length());
                    System.out.println(" null=" + found_null + " length= " + found_null.length());

                } else {

                    for (int j = 0; j < numbers[i].length(); j++) {
                        ret.append(numbers[i].charAt(j));
                        if (j < (numbers[i].length() - 1)) {
                            ret.append(" + ");
                        }
                    }
                    if (!matcher.hitEnd()) {
                        ret.append(StringUtils.center("+", found_null.length() + (1 + found_null.length()) * 3));
                    }
                    System.out.print(" ELSE: num=" + found_num + " length= " + found_num.length());
                    System.out.println(" null=" + found_null + " length= " + found_null.length() + " hitEnd=" + matcher.hitEnd());
                }
        
            }
                System.out.println("i="+i+" numbers.["+i+"]="+numbers[i]);    
        } else {
            System.out.println("NOT MATCHES!");
        }
        /*(if (found) {
            System.out.println("Result: Matches");
        } else {
            System.out.println("Result: Not matches");
        }*/
        for (char c : line.toCharArray()) {
            System.out.print(c + " + ");
        }
        System.out.println("\nReturn:\n" + ret.toString());
        //String[] ar = pattern.split(line);

    }

    private ArrayList<Integer> convert33(MultiValuedMap<Integer, ArrayList<Integer>> mvm) {
        ArrayList<Integer> ret = new ArrayList<>();

        return ret;
    }
}
