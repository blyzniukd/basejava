package com.blyzniukd.hw.model;

public class Contact implements PrintHtmlInterface {
    private ContactType type;
    private Description description;

    public Contact(ContactType type, Description description) {
        this.type = type;
        description.setDescription(type.getPrefix() + description.getDescription());
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
}
