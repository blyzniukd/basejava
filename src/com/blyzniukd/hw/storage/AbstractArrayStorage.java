package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.data.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 100_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int position = getIndex(resume.getUuid());
        if (position != -1) {
            storage[position] = resume;
        } else {
            System.out.println("Resume object with UUID[" + resume.getUuid() + "] is not exist.");
        }
    }

    public Resume get(String uuid) {
        int position = getIndex(uuid);
        if (position != -1) {
            return storage[position];
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
            return null;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
