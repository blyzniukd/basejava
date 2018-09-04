package com.blyzniukd.hw.model.description;

public class ListDescription extends Description {
    public ListDescription(String description) {
        super(description);
    }

    @Override
    public String printHtml() {
        return makeListElement(super.printHtml());
    }

    private String makeListElement( String text){
        return  "<li>" + text + "</li>";
    }
}
