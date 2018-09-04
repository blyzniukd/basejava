package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.sections.Experience;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ExperienceTest {
        Experience a = new Experience();


        @Before
        public void setUp() {
            a.clear();
            a.add("Java Online Projects", "http://javaops.ru/", new Date(2010,9,1), new Date(2011,0, 1), "Автор проекта" ,"Создание, организация и проведение Java онлайн проектов и стажировок.");
//            a.add(desc1);
//            a.add(desc2);
//            a.add(desc3);
//            a.add(desc4);
//            a.add(desc_repeated);
        }

        @Test
        public void printresult() {
            System.out.println(a.printHtml());
        }

}
