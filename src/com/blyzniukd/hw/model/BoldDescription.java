package com.blyzniukd.hw.model;

public class BoldDescription extends Description {

    public BoldDescription(String description) {
        super(description);
    }

    @Override
    public String printHtml() {
        return "<b>" + super.printHtml() + "</b>";
    }
}
