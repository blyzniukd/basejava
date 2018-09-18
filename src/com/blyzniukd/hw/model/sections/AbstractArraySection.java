package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArraySection<E> extends AbstractSection {
    protected List<E> list = new ArrayList<>();

    public AbstractArraySection(String text) {
        super(text);
    }

    public List<E> getList() {
        return new ArrayList<>(list);
    }

    public void add(E record) {
        if (!list.contains(record)) {
            list.add(record);
        }
    }

    public void delete(E record) {
        list.remove(record);
    }

    public void clear() {
        list.clear();
    }

}
