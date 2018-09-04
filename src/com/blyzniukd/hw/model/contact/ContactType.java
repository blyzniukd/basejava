package com.blyzniukd.hw.model.contact;

public enum ContactType {
    EMAIL("Почта", "mailto:"),
    OTHER("Другие", ""),
    PHONE("Телефон", ""),
    SITE("Сайт", "https://"),
    SKYPE("Skype", "skype:"),
    SOCIAL("Социальные сети", "");

    private String description;
    private String prefix;

    ContactType(String description, String prefix) {
        this.description = description;
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public String getPrefix() {
        return prefix;
    }
}
