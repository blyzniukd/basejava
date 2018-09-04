package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;

public class Personal extends AbstractSection {

    private static final String HEADER = "Личные качества";
    private Description description;

    public Personal() {
        super(HEADER);
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String printHtml() {
        return super.printHtml()+description.printHtml();
    }
}
