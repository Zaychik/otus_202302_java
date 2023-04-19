package main.java.ru.otus;

import main.java.ru.otus.annotations.After;
import main.java.ru.otus.annotations.Before;
import main.java.ru.otus.annotations.Test;
import main.java.ru.otus.dao.MethodItem;
import main.java.ru.otus.dao.MethodRunStatus;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

import static main.java.ru.otus.reflection.ReflectionHelper.callMethod;

public class RunnerTest
{
    public static void main(String[] args) {
        RunnerTest sr = new RunnerTest();
        sr.run();
    }

    private void run() {
        try {
            String className = "main.java.ru.otus.dao.ClassTest";
            LinkedList<MethodItem> listTestMethod = new LinkedList<>();
            LinkedList<MethodItem> listBeforeMethod = new LinkedList<>();
            LinkedList<MethodItem> listAfterMethod = new LinkedList<>();

            getMethods(className, listTestMethod, listBeforeMethod, listAfterMethod);
            runTests(className, listTestMethod, listBeforeMethod, listAfterMethod);

            printResult(listTestMethod);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printResult(LinkedList<MethodItem> listTestMethod) {
        Integer countAll = 0, countSuccess = 0, countFail = 0;
        countAll = listTestMethod.size();
        System.out.printf("\n");
        System.out.printf("\n");
        System.out.printf("-------------------------------");
        System.out.printf("\n");
        for (MethodItem m : listTestMethod) {
            if (m.getResult().getStatus() == MethodRunStatus.Success) {
                countSuccess++;
            }
            else if (m.getResult().getStatus() == MethodRunStatus.Error) {
                countFail++;
            }
            System.out.printf(m.toString());
        }
        System.out.printf("Всего тестов - " + countAll + "\n"
                + "Успешных тестов - " + countSuccess+ "\n"
                + "Тестов с ошибкой - " + countFail);
    }

    private void runTests(String className,
                          LinkedList<MethodItem> listTestMethod,
                          LinkedList<MethodItem> listBeforeMethod,
                          LinkedList<MethodItem> listAfterMethod) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class cl = Class.forName(className);
        Constructor cst = cl.getConstructor();

        for (MethodItem m : listTestMethod) {
            try {
                Object entity = cst.newInstance();
                runList(entity, listBeforeMethod);

                m.getName().invoke(entity);

                runList(entity, listAfterMethod);
                m.getResult().setStatus(MethodRunStatus.Success);
            } catch (Exception e) {
                m.getResult().setStatus(MethodRunStatus.Error);
                m.getResult().setErrorName(e.getCause().toString());
            }
        }
    }

    private void runList(Object entity, LinkedList<MethodItem> list) throws InvocationTargetException, IllegalAccessException {
        for (MethodItem m : list) {
            try {
                m.getName().invoke(entity);
                m.getResult().setStatus(MethodRunStatus.Success);
            } catch (Exception e) {
                m.getResult().setStatus(MethodRunStatus.Error);
                m.getResult().setErrorName(e.toString());
                throw e;
            }


        }
    }

    private void getMethods(String className,
                            LinkedList<MethodItem> listTestMethod,
                            LinkedList<MethodItem> listBeforeMethod,
                            LinkedList<MethodItem> listAfterMethod) throws ClassNotFoundException {
        Class cl = Class.forName(className);
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                listTestMethod.add(new MethodItem(m));
            } else if (m.isAnnotationPresent(Before.class)) {
                listBeforeMethod.add(new MethodItem(m));
            } else if (m.isAnnotationPresent(After.class)) {
                listAfterMethod.add(new MethodItem(m));
            }
        }
    }


}