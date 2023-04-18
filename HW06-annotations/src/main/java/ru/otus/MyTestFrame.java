package main.java.ru.otus;

import main.java.ru.otus.annotations.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTestFrame
{
    public static void main(String[] args) {
        MyTestFrame sr = new MyTestFrame();

        sr.runTests();
    }

    private void runTests() {
        try {
            Class cl = Class.forName("main.java.ru.otus.dao.CheckMyTestFrame");

            Constructor cst = cl.getConstructor();
            Object entity = cst.newInstance();

            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                Test ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}