package main.java.ru.otus.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodItem {
    private Method Name;
    private MethodRunResult result;

    public MethodRunResult getResult() {
        return result;
    }

    public void setResult(MethodRunResult result) {
        this.result = result;
    }

    public MethodItem(Method name) {
        Name = name;
        result = new MethodRunResult();

    }

    public Method getName() {
        return Name;
    }

    public void setName(Method name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "MethodName=" + Name.getName() +
                ", result=" + result;
    }
}
