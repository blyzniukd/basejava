package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.StorageException;
import com.blyzniukd.hw.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected static final int STORAGE_LIMIT = 10;
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        if (size < STORAGE_LIMIT) {
            if ((Integer) index < 0) {
                insertResume(resume, (Integer)index);
                size++;
            }
        } else {
            throw new StorageException("The array is full. Try to delete element from array before save.", resume.getUuid());
        }

    }

    @Override
    protected void doDelete(Object index) {
            deleteResume((Integer)index);
            storage[size - 1] = null;
            size--;
    }

    @Override
    protected boolean isExistElement(Object index) {
        return (Integer) index>=0;
    }

    @Override
    protected Resume getElement(Object index) {
        return storage[(Integer) index];
    }


    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract Integer findKeyObject(String uuid);

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

    public int size() {
        return size;
    }
}
