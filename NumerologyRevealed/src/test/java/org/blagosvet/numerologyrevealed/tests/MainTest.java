package org.blagosvet.numerologyrevealed.tests;

/**
 *
 * @author dmitri
 */
//import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.blagosvet.numerologyrevealed.m.Person;
import org.blagosvet.numerologyrevealed.m.SpecialNumbers;

/*
    fail(String)
  Указывает на то что бы тестовый метод завалился при этом выводя текстовое сообщение.
    assertTrue([message], boolean condition)
  Проверяет, что логическое условие истинно.
    assertEquals([String message], expected, actual)
  Проверяет, что два значения совпадают. Примечание: для массивов проверяются ссылки, а не содержание массивов.
    assertNull([message], object)
  Проверяет, что объект является пустым null.
    assertNotNull([message], object)
  Проверяет, что объект не является пустым null.
    assertSame([String], expected, actual)
  Проверяет, что обе переменные относятся к одному объекту.
    assertNotSame([String], expected, actual)
  Проверяет, что обе переменные относятся к разным объектам.
 */
public class MainTest {
    //John Lucas Peterson
    // 22-dec-1972
    // JLPETERSON

    @Test
    public void Person() {
        Person p = new Person("John", "Lucas", "Peterson", "JLPETERSON", 1972, 12, 22);
        String actual = "John Lucas Peterson JLPETERSON 1972-12-22";
        String expected = p.toString();
        assertEquals("Person testing ", expected, actual);
    }

    @Test
    public void PowerNumber() {
        SpecialNumbers sn = new SpecialNumbers();
        int[] actual = sn.getPowerNumbers();
        int[] expected = {33, 22, 11};
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void KarmicNumber() {
        SpecialNumbers sn = new SpecialNumbers();
        int[] actual = sn.getKarmicNumbers();
        int[] expected = {13, 15, 16, 19};
        assertTrue(Arrays.equals(expected, actual));
    }
}
