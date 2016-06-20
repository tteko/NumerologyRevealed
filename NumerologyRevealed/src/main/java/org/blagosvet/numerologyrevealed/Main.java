package org.blagosvet.numerologyrevealed;

//import org.blagosvet.numerologyrevealed.ToDo;

import org.blagosvet.numerologyrevealed.m.Person;
import org.blagosvet.numerologyrevealed.c.Computation;

public class Main {

    public static void main(String[] args) {
        //HashMap<Character,Integer> hm = new HashMap<>();
        //hm.put('A',1);

        //Person person = new Person("John", "Lucas", "Peterson", "JLPETERSON", 1972, 12, 22);
        Person person = new Person("John", "Lucas", "Peterhsonfgennadiich", "JLPETERSON", 1972, 12, 22);
        //Person person = new Person("Дмитрий", "Геннадьевич", "Безгодов", "Безгодов", 1967, 3, 27);
        Computation computation = new Computation(person);
        ToDo toDo = new ToDo();
    }
}
