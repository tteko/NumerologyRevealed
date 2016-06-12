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
        Person person = new Person("Святослав", "Дмитриевич", "Безгодов", "Безгоодооов", 2010, 2, 15);
        String name = person.getSignature();
        ArrayList<Integer> pTypeName = new ArrayList<>();
        //ArrayList<Integer> pTypeName = new ArrayList<>();
        //[2, 0, 8, 7, 0, 4, 0, 4]
        int allnums[] = {2, 0, 8, 7, 0, 0, 4, 0, 0, 0, 4};
        StringBuilder sb = new StringBuilder();
        
        for (int d : allnums) {
            pTypeName.add(d);
            sb.append(d);
        }
        System.out.println(sb);
        //==
        Pattern pattern = Pattern.compile("0+");
        Matcher matcher = pattern.matcher(sb.toString());
        String[] ar = pattern.split(sb.toString());
        for (String s : ar) {
            System.out.print(s);
            String found;
            if(matcher.find()){
                found = matcher.group();
                int s_length = found.length();
                System.out.print(StringUtils.center("+", s_length));
            }
        }
        System.out.println();
        
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
        //==
        for (char c : name.toCharArray()) {
            System.out.print(" " + c);
        }
        System.out.println();
        
        System.out.print(" ");
        for (int i = 0; i < (pTypeName.size() - 1); i++) {
            int d = pTypeName.get(i);
            System.out.print(d + "+");
        }
        System.out.println(pTypeName.get(pTypeName.size() - 1));
        
        int[] n = {11, 2, 8, 4};
        
    }
}
