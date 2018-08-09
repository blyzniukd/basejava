package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected Integer findKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        int position = -index - 1;
        System.arraycopy(storage, position, storage, position + 1, size - position);
        storage[position] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}
