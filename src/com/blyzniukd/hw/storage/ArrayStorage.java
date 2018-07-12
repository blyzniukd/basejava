package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    protected int getIndex(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                position = i;
            }
        }
        return position;
    }

    protected void insertResume(Resume r, int position) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int position) {
        storage[position] = storage[size - 1];
    }
}
