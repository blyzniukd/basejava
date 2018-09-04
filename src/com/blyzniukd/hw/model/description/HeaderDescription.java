package com.blyzniukd.hw.model.description;

public class HeaderDescription extends Description {
    public HeaderDescription(String description) {
        super(description);
    }

    @Override
    public String printHtml() {
        return makeHeader(super.printHtml());
    }

    private String makeHeader (String text){
        return "<h1>" + text + "</h1>";
    }
}
