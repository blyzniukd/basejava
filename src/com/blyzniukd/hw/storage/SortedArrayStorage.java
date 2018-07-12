package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertResume(Resume r, int position) {
        for (int i = size; i > -position - 1; i--) {
            storage[i] = storage[i - 1];
        }
        storage[-position - 1] = r;
    }

    @Override
    protected void deleteResume(int position) {
        for (int i = position; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

}
