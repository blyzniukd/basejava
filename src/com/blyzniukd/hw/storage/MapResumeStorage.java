package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<String, Resume>();

    @Override
    protected Resume findKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume doGet(Object r) {
        return storage.get(((Resume) r).getUuid());
    }

    @Override
    protected boolean isExist(Object r) {
        return r != null;
    }

    @Override
    protected void doUpdate(Object r, Resume resume) {
        this.doSave(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Object r, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object r) {
        storage.remove(((Resume) r).getUuid());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }
}
