package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;

public abstract class AbstractSection {
    protected Description header;

    public AbstractSection(String text) {
        this.header = new Description(text);
    }

}
