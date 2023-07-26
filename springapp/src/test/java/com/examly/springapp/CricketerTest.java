package com.examly.springapp;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.internal.function.Parameter;

import java.lang.reflect.Method;
// import java.lang.reflect.Field;
// import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CricketerTest {

    @Test
    public void testAddCricketers() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));

        assertEquals(2, cricketersList.size(), "Number of cricketers added should be 2");
    }

    @Test
    public void testSortCricketersByName() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList);

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "First cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Third cricketer should be Virat Kohli");
    }

    @Test
    public void testSortCricketersByAge() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList, new CricketerAgeComparator());

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "Youngest cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second youngest cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Oldest cricketer should be Virat Kohli");
    }

    @Test
	public void test_field(){
		Class targetClass = SpringappApplication.class;
		Class dataType = ArrayList.class;
		// String fieldName = "<<field-name>>";

        Method[] field = targetClass.getDeclaredMethods();

        // System.out.println("*****************"+field.length+"*********************");

        for(Method f: field){
            java.lang.reflect.Parameter[] temp = f.getParameters();
            System.out.println("*****************"+Arrays.toString(temp)+"*********************");
        }

		// assertEquals( true, field != null);

		// assertEquals(true, field.getType().equals(dataType));
	}
}