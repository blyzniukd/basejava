package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.description.ListDescription;
import com.blyzniukd.hw.model.sections.Qualifications;
import org.junit.Before;
import org.junit.Test;

public class QualificationsTest {
    Qualifications a = new Qualifications();
    ListDescription desc = new ListDescription("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
    ListDescription desc1 = new ListDescription("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ");
    ListDescription desc2 = new ListDescription("Version control: Subversion, Git, Mercury, ClearCase, Perforce ");
    ListDescription desc3 = new ListDescription("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
    ListDescription desc4 = new ListDescription("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, ");
    ListDescription desc_repeated = new ListDescription("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, ");

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
        System.out.println(a.printHtml());
    }
}
