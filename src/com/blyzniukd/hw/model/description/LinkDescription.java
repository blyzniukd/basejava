package com.blyzniukd.hw.model.description;

public class LinkDescription extends Description {

    private final String  PREFIX_HTTPS = "https://";

    private String link;
    private String prefix;


    public LinkDescription(String description, String link) {
        super(description);
        this.link = link;
        this.prefix= PREFIX_HTTPS;
    }

    public LinkDescription(String description, String link, String prefix) {
        super(description);
        this.link = link;
        this.prefix = prefix;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String printHtml() {
        return makeLink(super.printHtml());
    }

    private String  makeLink (String text){
        return "<a href=\"" + prefix + link + "\">" + text + "</a>";
    }

    @Override
    public String toString() {
        return "LinkDescription{" +
                "link='" + link + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
