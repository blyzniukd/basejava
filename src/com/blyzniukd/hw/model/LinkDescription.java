package com.blyzniukd.hw.model;

public class LinkDescription extends Description {

    private String link;

    public LinkDescription(String description) {
        super(description);
        this.link = description;
    }

    public LinkDescription(String description, String link) {
        super(description);
        this.link = link;
    }

    @Override
    public String printHtml() {
        return "<a href=\"" + link + "\">" + super.printHtml() + "</a>";
    }
}
