package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<String, Resume>();

    @Override
    protected Object findKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume doGet(Object keyObject) {
        return storage.get(keyObject);
    }

    @Override
    protected boolean isExist(Object keyObject) {
        return storage.containsKey(keyObject);
    }

    @Override
    protected void doUpdate(Object keyObject, Resume resume) {
        this.doSave(keyObject, resume);
    }

    @Override
    protected void doSave(Object keyObject, Resume resume) {
        storage.put(((Resume) keyObject).getUuid(), resume);
    }

    @Override
    protected void doDelete(Object keyObject) {
        storage.remove(keyObject);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
