package com.blyzniukd.hw.model.contact;

import com.blyzniukd.hw.model.PrintHtmlInterface;
import com.blyzniukd.hw.model.description.Description;

import java.util.Objects;

public class Contact implements PrintHtmlInterface {
    private ContactType type;
    private Description description;

    public Contact(ContactType type, Description description) {
        this.type = type;
        this.description = description;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        String d = new Description("").getDescription();
        this.type = type;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String printHtml() {
        return type.getDescription() + ":" + description.printHtml();
    }

    @Override
    public String toString() {
        return "Type:" + type.getDescription() + "." + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return type == contact.type &&
                Objects.equals(description, contact.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description);
    }

}
