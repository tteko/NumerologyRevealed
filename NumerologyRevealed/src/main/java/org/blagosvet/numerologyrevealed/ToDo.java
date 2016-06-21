package org.blagosvet.numerologyrevealed;

/**
 *
 * @author dmitri
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import org.blagosvet.numerologyrevealed.m.Person;

public class ToDo {

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
        int allnums[] = {0, 0, 2, 0, 8, 7, 0, 0, 4, 0, 0, 0, 4, 0, 0};
        StringBuilder sb = new StringBuilder();

        for (int d : allnums) {
            sb.append(d);
        }
        System.out.println("sb: " + sb);

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
        // 1. Print the name
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
    }
}
