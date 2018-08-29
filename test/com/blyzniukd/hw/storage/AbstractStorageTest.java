package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.ExistStorageException;
import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_NEW = "uuidNEW";

    private final Resume resume_1 = new Resume(UUID_1, "Dima 1");
    private final Resume resume_2 = new Resume(UUID_2, "Dima 2");
    private final Resume resume_3 = new Resume(UUID_3, "Dima 3");
    private final Resume resume_4 = new Resume(UUID_NEW, "Dima NEW ");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
        assertEquals(new ArrayList<Resume>(), storage.getAllSorted());
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "New Name");
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistException() {
        storage.get(UUID_NEW);
    }

    @Test
    public void save() {
        storage.save(resume_4);
        assertEquals(4, storage.size());
        assertEquals(resume_4, storage.get(resume_4.getUuid()));
    }


    @Test(expected = ExistStorageException.class)
    public void saveExistException() {
        storage.save(resume_2);
    }

    @Test
    public void get() {
        assertEquals(resume_2, storage.get(resume_2.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistException() {
        storage.get(resume_4.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(resume_3.getUuid());
        assertEquals(2, storage.size());
        storage.get(resume_3.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistException() {
        storage.delete(resume_4.getUuid());
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(Arrays.asList(resume_1, resume_2, resume_3), list);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

}
