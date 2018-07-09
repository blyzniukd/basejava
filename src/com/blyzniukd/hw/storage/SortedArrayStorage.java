package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.data.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (size < STORAGE_LIMIT) {
            int position = findIndexToInsert(r);
            if (getIndex(r.getUuid()) < 0 && position != -1) {
                shiftElements(position, r, true);
            } else {
                System.out.println("Resume with same UUID[" + r.getUuid() + "] is exist.");
            }
        } else {
            System.out.println("The array is full. Try to delete element from array before save.");
        }
    }

    @Override
    public void delete(String uuid) {
        shiftElements(getIndex(uuid), null, false);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    private int findIndexToInsert(Resume r) {
        int position = -1;
        if (size == 0) {
            position = 0;
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i].hashCode() > r.hashCode()) {
                    position = i;
                    break;
                }
                position = i + 1;
            }
        }
        return position;
    }

    private void shiftElements(int position, Resume r, boolean increase) {
        if (increase) {
            if (size != 0) {
                for (int i = size; i > position; i--) {
                    storage[i] = storage[i - 1];
                }
            }
            storage[position] = r;
            size++;
        } else {
            for (int i = position; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
            size--;
        }
    }
}
