package com.blyzniukd.hw.model;

public class Description implements PrintHtmlInterface {
    private String description;

    public Description(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String printHtml() {
        return description;
    }

    @Override
    public String toString() {
        return "Description:" + description;
    }
}
