package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;

public class Achievement extends AbstractArraySection<Description> {
    private static final String HEADER = "Достижения";


    public Achievement() {
        super(HEADER);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Achievment{")
                .append("Name=").append(HEADER).append(System.getProperty("line.separator"))
                .append("list=").append(System.getProperty("line.separator"));
        getList().forEach((e) -> {
            sb.append(e + System.getProperty("line.separator"));
        });
        sb.append('}');
        return sb.toString();
    }
}
