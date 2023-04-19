package main.java.ru.otus.dao;

import main.java.ru.otus.annotations.After;
import main.java.ru.otus.annotations.Before;
import main.java.ru.otus.annotations.Test;

public class ClassTest {
    @Test
    public void testExample1() {
        System.out.println("TEST 1");
    }

    @Test
    public void testExample2() throws NullPointerException {
        throw new NullPointerException("Test exception");


    }

    @Before
    public void beforeExample2() {
        System.out.println("beforeExample2");
    }

    @After
    public void afterExample2() {
        System.out.println("afterExample2");
    }

    @Before
    public void beforeExample1() {
        System.out.println("beforeExample1");
    }

    @After
    public void afterExample1() {
        System.out.println("afterExample1");
    }


}
