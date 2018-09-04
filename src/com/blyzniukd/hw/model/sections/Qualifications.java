package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.ListDescription;

public class Qualifications extends AbstractArraySection<ListDescription>  {
    public static final String HEADER = "Квалификация";

    public Qualifications() {
        super(HEADER);
    }
}
