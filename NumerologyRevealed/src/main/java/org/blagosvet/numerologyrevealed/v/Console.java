package org.blagosvet.numerologyrevealed.v;

/**
 *
 * @author dmitri
 */
import org.blagosvet.numerologyrevealed.m.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public Console(Person person) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("First name: ");
            person.setFirstName(br.readLine());

            System.out.print("Middle name: ");
            person.setMiddleName(br.readLine());

            System.out.print("Last name: ");
            person.setLastName(br.readLine());

            boolean done = false;
            do {

                int yyyy = -1;
                do {
                    System.out.print("Birth Year (yyyy), e.g. 1980: ");
                    try {
                        yyyy = Integer.parseInt(br.readLine());
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Year Format! Please enter (yyyy), e.g. 1980");
                        yyyy = -1;
                    }
                    if (yyyy != -1) {
                        break;
                    }
                } while (yyyy == -1);

                int mm = -1;
                do {
                    System.out.print("Birth Month (1-12), e.g. 9: ");
                    try {
                        mm = Integer.parseInt(br.readLine());
                        mm--;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Month Format! Please enter (1-12), e.g. 9");
                        mm = -1;
                    }
                    if (mm != -1) {
                        break;
                    }
                } while (mm == -1);

                int dd = -1;
                do {
                    System.out.print("Birth day (1-31), e.g. 18: ");
                    try {
                        dd = Integer.parseInt(br.readLine());
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Day Format! Please enter (1-31), e.g. 18");
                        dd = -1;
                    }
                    if (dd != -1) {
                        break;
                    }
                } while (dd == -1);

                try {
                    person.setCalendar(yyyy, mm, dd);
                    done = true;
                } catch (IllegalArgumentException iae) {
                    System.err.println("Invalid Date Format! Please, re-enter!");
                }

                System.out.print("Signature: ");
                person.setSignature(br.readLine());

            } while (!done);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
