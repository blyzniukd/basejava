package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.sections.Personal;
import org.junit.Test;

public class PersonalTest {
    Personal personal = new Personal("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. ");


    @Test
    public void printresult() {
        System.out.println(personal);
    }
}
