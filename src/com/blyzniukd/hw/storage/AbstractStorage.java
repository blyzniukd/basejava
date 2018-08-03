package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.ExistStorageException;
import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.model.Resume;

public abstract class AbstractStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10;
    protected int size = 0;

    protected abstract Object findKeyObject(String uuid);
    protected abstract Resume getElement(Object keyObject);
    protected abstract boolean isExistElement(Object  keyObject);
    protected abstract void doUpdate(Object keyObject, Resume resume);
    protected abstract void doSave(Object keyObject, Resume resume);
    protected abstract void doDelete(Object keyObject);

    public void update(Resume resume){
        Object keyObject = getKeyOfExistObject(resume.getUuid());
        doUpdate(keyObject, resume);
    }

    public void save(Resume resume){
        Object keyObject = getKeyOfNotExistObject(resume.getUuid());
        doSave(keyObject, resume);
    }

    public Resume get(String uuid){
     Object keyObject =  findKeyObject(uuid);
     return getElement(keyObject);
    }

    public void delete(String uuid){
        Object keyObject = getKeyOfExistObject(uuid);
        doDelete(keyObject);
    }

    private Object getKeyOfExistObject(String uuid){
        Object keyObject = findKeyObject(uuid);
        if ( !isExistElement(keyObject)){
            throw new NotExistStorageException(uuid);
        }
        return keyObject;
    }

    private Object getKeyOfNotExistObject(String uuid){
        Object keyObject = findKeyObject(uuid);
        if ( isExistElement(keyObject)){
            throw new ExistStorageException(uuid);
        }
        return keyObject;
    }

    public int size() {
        return size;
    }
}
