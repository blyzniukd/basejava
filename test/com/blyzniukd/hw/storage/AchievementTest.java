package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.sections.Achievement;
import org.junit.Before;
import org.junit.Test;

public class AchievementTest {

    Achievement a = new Achievement();
    Description desc = new Description("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников. ");
    Description desc1 = new Description("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ");
    Description desc2 = new Description("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ");
    Description desc3 = new Description("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга. ");
    Description desc4 = new Description("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
    Description desc_repeated = new Description("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

    @Before
    public void setUp() {
        a.clear();
        a.add(desc);
        a.add(desc1);
        a.add(desc2);
        a.add(desc3);
        a.add(desc4);
        a.add(desc_repeated);

    }

    @Test
    public void printresult() {
        System.out.println( a.getList().contains(desc_repeated));

        System.out.println(a);
    }
}
