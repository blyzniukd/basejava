package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.contact.Contact;
import com.blyzniukd.hw.model.contact.ContactType;
import com.blyzniukd.hw.model.contact.Contacts;
import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.description.LinkDescription;
import org.junit.Before;
import org.junit.Test;

public class ContactsTest {
    private Contacts contacts = new Contacts();

    private static final Contact PHONE = new Contact(ContactType.PHONE, new Description("+000 000 000 0"));
    private static final Contact SKYPE = new Contact(ContactType.SKYPE, new LinkDescription("dmitry_blyzniuk", "dmitry_blyzniuk", ContactType.SKYPE.getPrefix()));
    private static final Contact EMAIL = new Contact(ContactType.EMAIL, new LinkDescription("blyzniukd@gmail.com", "blyzniukd@gmail.com", ContactType.EMAIL.getPrefix()));
    private static final Contact SITE = new Contact(ContactType.SITE, new LinkDescription("My Site", "mysite@gmail.com"));
    private static final Contact SOCIAL1 = new Contact(ContactType.SOCIAL, new LinkDescription("LinkedIn", "www.linkedin.com/in/gkislin"));
    private static final Contact SOCIAL2 = new Contact(ContactType.SOCIAL, new LinkDescription("GitHub", "github.com/gkislin"));

    @Before
    public void setUp() {
        contacts.clear();
        contacts.add(PHONE);
        contacts.add(SKYPE);
        contacts.add(EMAIL);
        contacts.add(SITE);
        contacts.add(SOCIAL2);
        contacts.add(SOCIAL1);
    }

    @Test
    public void printresult() {
        System.out.println(contacts);
        contacts.delete(EMAIL);
        System.out.println("After delete="+contacts);
    }
}
