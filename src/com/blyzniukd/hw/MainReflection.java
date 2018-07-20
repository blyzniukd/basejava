package com.blyzniukd.hw;

import com.blyzniukd.hw.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume();
        System.out.println(resume);
        Method method = resume.getClass().getMethod("toString");
        System.out.println("invoke toString method =" + method.invoke(resume));
    }
}
