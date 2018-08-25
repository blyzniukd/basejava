package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.*;
import java.util.stream.Collectors;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<String, Resume>();

    @Override
    protected Object findKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(Object keyObject) {
        return storage.get((String)keyObject);
    }

    @Override
    protected boolean isExist(Object keyObject) {
        return storage.containsKey((String)keyObject);
    }

    @Override
    protected void doUpdate(Object keyObject, Resume resume) {
        this.doSave(keyObject, resume);
    }

    @Override
    protected void doSave(Object keyObject, Resume resume) {
        storage.put((String) keyObject, resume);
    }

    @Override
    protected void doDelete(Object keyObject) {
        storage.remove((String)keyObject);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return  storage.values().stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return storage.size();
    }
}
