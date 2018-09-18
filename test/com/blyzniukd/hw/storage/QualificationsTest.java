package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.sections.Qualifications;
import org.junit.Before;
import org.junit.Test;

public class QualificationsTest {
    Qualifications a = new Qualifications();
    Description desc = new Description("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
    Description desc1 = new Description("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ");
    Description desc2 = new Description("Version control: Subversion, Git, Mercury, ClearCase, Perforce ");
    Description desc3 = new Description("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
    Description desc4 = new Description("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, ");
    Description desc_repeated = new Description("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, ");

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
        System.out.println(a);
    }
}
