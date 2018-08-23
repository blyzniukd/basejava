package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.ExistStorageException;
import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AbstractStorageTest {
    protected final Storage storage;
    private final Resume resume_1 = new Resume("uuid1", "Dima 1");
    private final Resume resume_2 = new Resume("uuid2", "Dima 2");
    private final Resume resume_3 = new Resume("uuid3", "Dima 3");
    private final Resume resume_4 = new Resume("uuidNEW", "Dima NEW ");

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
        Assert.assertEquals(0, storage.size());
        Assert.assertArrayEquals(new ArrayList<Resume>().toArray(), storage.getAll().toArray());
    }

    @Test
    public void update() {
        storage.update(resume_1);
        Assert.assertEquals(resume_1, storage.get(resume_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistException() {
        storage.update(resume_4);
    }

    @Test
    public void save() {
        storage.save(resume_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(resume_4, storage.get(resume_4.getUuid()));
    }


    @Test(expected = ExistStorageException.class)
    public void saveExistException() {
        storage.save(resume_2);
    }

    @Test
    public void get() {
        Assert.assertEquals(resume_2, storage.get(resume_2.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistException() {
        storage.get(resume_4.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(resume_3.getUuid());
        Assert.assertEquals(2, storage.size());
        storage.get(resume_3.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistException() {
        storage.delete(resume_4.getUuid());
    }

    @Test
    public void getAll() {
        List<Resume> array = storage.getAll();
        Assert.assertEquals(3, array.size());
        Assert.assertEquals(resume_1, array.get(0));
        Assert.assertEquals(resume_2, array.get(1));
        Assert.assertEquals(resume_3, array.get(2));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

}
