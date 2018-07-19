package com.blyzniukd.hw;

import com.blyzniukd.hw.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume r = new Resume();
        System.out.println(r);
        Method m = r.getClass().getMethod("toString", null);
        System.out.println("invoke toString method =" + m.invoke(r, null));
    }
}
