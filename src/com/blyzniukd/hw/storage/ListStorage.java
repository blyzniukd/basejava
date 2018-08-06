package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer findKeyObject(String uuid) {
        for (int i=0; i< list.size(); i++){
            if( list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume getElement(Object keyObject) {
        return list.get((Integer) keyObject);
    }

    @Override
    protected boolean isExistElement(Object keyObject) {
        return keyObject != null;
    }

    @Override
    protected void doUpdate(Object keyObject, Resume resume) {
        list.set((Integer) keyObject, resume);
    }

    @Override
    protected void doSave(Object keyObject, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void doDelete(Object keyObject) {
        list.remove(((Integer) keyObject).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray( new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
