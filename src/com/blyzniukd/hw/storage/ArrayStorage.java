package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.data.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Resume with same UUID[" + r.getUuid() + "] is exist.");
            }
        } else {
            System.out.println("The array is full. Try to delete element from array before save.");
        }
    }

    public void delete(String uuid) {
        int position = getIndex(uuid);
        if (position != -1) {
            storage[position] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
        }
    }

    protected int getIndex(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                position = i;
            }
        }
        return position;
    }
}
