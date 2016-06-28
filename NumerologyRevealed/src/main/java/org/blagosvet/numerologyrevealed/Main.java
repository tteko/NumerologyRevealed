package org.blagosvet.numerologyrevealed;

//import org.blagosvet.numerologyrevealed.ToDo;
import java.util.ArrayList;
import java.util.stream.Collectors;
//import java.util.ArrayDeque;

import org.blagosvet.numerologyrevealed.m.Person;
import org.blagosvet.numerologyrevealed.c.Computation;
//
//import org.blagosvet.numerologyrevealed.v.console.Booklet;

public class Main {

    public static void main(String[] args) {
        //HashMap<Character,Integer> hm = new HashMap<>();
        //hm.put('A',1);

        //Person person = new Person("John", "Lucas", "Peterson", "JLPETERSON", 1972, 12, 22);
        Person person = new Person("John", "Lucas", "Peterhsonfgennadiich", "JLPETERSON", 1972, 12, 22);
        //Person person = new Person("Дмитрий", "Геннадьевич", "Безгодов", "Безгодов", 1967, 3, 27);
        //Computation computation = new Computation(person);
        ToDo toDo = new ToDo();
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        String listString = list.stream().map(Object::toString)
                        .collect(Collectors.joining("+"));
        System.out.println(listString);
        */
    }
}
