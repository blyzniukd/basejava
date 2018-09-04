package com.blyzniukd.hw.model.contact;

import com.blyzniukd.hw.model.PrintHtmlInterface;

import java.util.ArrayList;
import java.util.List;

public class Contacts implements PrintHtmlInterface {

    private List<Contact> contacts = new ArrayList<>();

    public void add(Contact record) {
        contacts.add(record);
    }

    public void update(Contact record) {
        int key = contacts.indexOf(record);
        if (key != -1){ contacts.set(key, record);}
    }

    public void delete( Contact record){
        int key = contacts.indexOf(record);
        if (key != -1){ contacts.remove(key);}
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
