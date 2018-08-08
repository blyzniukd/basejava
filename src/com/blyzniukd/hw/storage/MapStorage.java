package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    protected Object findKeyObject(String uuid) {
        return null;
    }

    @Override
    protected Resume doGet(Object keyObject) {
        return null;
    }

    @Override
    protected boolean isExist(Object keyObject) {
        return false;
    }

    @Override
    protected void doUpdate(Object keyObject, Resume resume) {

    }

    @Override
    protected void doSave(Object keyObject, Resume resume) {

    }

    @Override
    protected void doDelete(Object keyObject) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
