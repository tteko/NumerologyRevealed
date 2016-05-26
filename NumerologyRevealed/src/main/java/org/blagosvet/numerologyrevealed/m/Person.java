package org.blagosvet.numerologyrevealed.m;

/**
 *
 * @author dmitri
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Person {

    private Locale locale = new Locale(Locale.getDefault().getLanguage());
    private GregorianCalendar calendar = new GregorianCalendar();
    //String[] months = new DateFormatSymbols(locale).getMonths();
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String signature = null;

    public Person() {
    }

    public Person(String fn, String mn, String ln, String sg, int birthYear, int birthMonth, int birthDay) {
        firstName = fn;
        middleName = mn;
        lastName = ln;
        signature = sg;
        try {
            this.calendar.set(birthYear, birthMonth - 1, birthDay);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String mn) {
        this.middleName = mn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String sg) {
        this.signature = sg;
    }

    public Integer getBirthDay() {
        return this.calendar.get(Calendar.DATE);
    }

    public Integer getBirthMonth() {
        return this.calendar.get(Calendar.MONTH);
    }

    public Integer getBirthYear() {
        return this.calendar.get(Calendar.YEAR);
    }

    public void setCalendar(int birthYear, int birthMonth, int birthDay) {
        try {
            this.calendar.set(birthYear, birthMonth - 1, birthDay);
        } catch (IllegalArgumentException iae) {
            //iae.printStackTrace();
            System.out.println(iae.getMessage());
        }
    }

    public GregorianCalendar getCalendar() {
        return this.calendar;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(getFirstName());
        s.append(" ");
        s.append(getMiddleName());
        s.append(" ");
        s.append(getLastName());
        s.append(" ");
        s.append(getSignature());
        s.append(" ");
        s.append(getBirthYear());
        s.append("-");
        s.append(getBirthMonth() + 1);
        s.append("-");
        s.append(getBirthDay());

        return (s.toString());
    }
}
