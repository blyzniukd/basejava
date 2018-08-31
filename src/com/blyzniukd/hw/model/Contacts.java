package com.blyzniukd.hw.model;

import java.util.ArrayList;
import java.util.List;

public class Contacts implements PrintHtmlInterface {

    private List<Contact> contacts = new ArrayList<>();

    public void addRecord(Contact record) {
        contacts.add(record);
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    public void clear() {
        contacts.clear();
    }

    @Override
    public String printHtml() {
        StringBuffer sb = new StringBuffer();
        contacts.forEach((e) -> sb.append(e.printHtml() + System.getProperty("line.separator")));
        return sb.toString();
    }
}
