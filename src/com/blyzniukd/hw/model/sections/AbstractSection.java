package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.HeaderDescription;
import com.blyzniukd.hw.model.PrintHtmlInterface;

public abstract class AbstractSection implements PrintHtmlInterface {
    protected HeaderDescription header;

    public AbstractSection(String text) {
        this.header = new HeaderDescription(text);
    }

    @Override
    public String printHtml() {
        return header.printHtml();
    }
}
