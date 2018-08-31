package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.*;
import org.junit.Before;
import org.junit.Test;

public class ContactsTest {
    private Contacts contacts = new Contacts();

    private static final Contact PHONE = new Contact(ContactType.PHONE, new Description("+000 000 000 0"));
    private static final Contact SKYPE = new Contact(ContactType.SKYPE, new LinkDescription("dmitry_blyzniuk"));
    private static final Contact EMAIL = new Contact(ContactType.EMAIL, new LinkDescription("blyzniukd@gmail.com"));

    @Before
    public void setUp() {
        contacts.clear();
        contacts.addRecord(PHONE);
        contacts.addRecord(SKYPE);
        contacts.addRecord(EMAIL);
    }

    @Test
    public void printresult() {
        System.out.println(contacts.printHtml());
    }
}
