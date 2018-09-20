package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.sections.Experience;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ExperienceTest {
    Experience a = new Experience();

    @Before
    public void setUp() {
        a.clear();
        a.add("Java Online Projects", "http://javaops.ru/", LocalDate.parse("2010-09-01"), LocalDate.parse("2011-01-01"), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        a.add("Java Online Projects", "http://javaops.ru/", LocalDate.parse("2010-09-01"), LocalDate.parse("2011-01-01"), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        a.add("Additional info", "http://javaops.ru/", LocalDate.parse("2010-09-01"), LocalDate.parse("2011-01-01"), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.");
    }

    @Test
    public void printresult() {
        System.out.println(a);
    }

}
