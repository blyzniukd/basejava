package com.blyzniukd.hw.model.description;

public class BoldDescription extends Description {

    public BoldDescription(String description) {
        super(description);
    }

    @Override
    public String printHtml() {
        return makeBold(super.printHtml());
    }

    private String makeBold( String text){
        return  "<b>" + text + "</b>";
    }
}
