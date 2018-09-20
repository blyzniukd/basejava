package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.sections.Education;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class EducationTest {

    Education edu = new Education();

    @Before
    public void setUp() {
        edu.clear();
        edu.add("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", LocalDate.parse("1984-09-01"), LocalDate.parse("1987-06-01"), "Закончил с отличием");
        edu.add("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", LocalDate.parse("1987-09-01"), LocalDate.parse("1993-07-01"), "Инженер (программист Fortran, C)");
        edu.add("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", LocalDate.parse("1993-09-01"), LocalDate.parse("1996-07-01"), "Аспирантура (программист С, С++)");
        edu.add("Alcatel", "http://www.alcatel.ru/", LocalDate.parse("1997-09-01"), LocalDate.parse("1998-03-01"), "6 месяцев обучения цифровым телефонным сетям (Москва)");
        edu.add("Alcatel", "http://www.alcatel.ru/", LocalDate.parse("1997-09-01"), LocalDate.parse("1998-03-01"), "6 месяцев обучения цифровым телефонным сетям (Москва)");
    }

    @Test
    public void printresult() {
        System.out.println(edu);
    }
}
