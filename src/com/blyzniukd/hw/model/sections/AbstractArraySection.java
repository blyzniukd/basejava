package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.PrintHtmlInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArraySection<E extends PrintHtmlInterface> extends AbstractSection {
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

    @Override
    public String printHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.printHtml());
        sb.append("<ul>");
        list.forEach((e) -> sb.append(e.printHtml()));
        sb.append("</ul>");
        return sb.toString();
    }
}
