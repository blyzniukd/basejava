package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.ExistStorageException;
import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.exception.StorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.blyzniukd.hw.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private final Resume resumeTest1 = new Resume("uuid1");
    private final Resume resumeTest2 = new Resume("uuid2");
    private final Resume resumeTest3 = new Resume("uuid3");
    private final Resume resumeTestNew = new Resume("uuidNEW");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resumeTest1);
        storage.save(resumeTest2);
        storage.save(resumeTest3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
        Assert.assertArrayEquals(new Resume[0], storage.getAll());
    }

    @Test
    public void update() {
        storage.update(resumeTest1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistException() {
        storage.update(resumeTestNew);
    }

    @Test
    public void save() throws Exception {
        storage.save(resumeTestNew);
    }

    @Test(expected = StorageException.class)
    public void saveOverloadException() throws Exception {
        try {
            for (int i = storage.size() - 1; i <= STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException ex) {
            if (storage.size() != STORAGE_LIMIT) {
                Assert.fail();
            } else {
                throw ex;
            }
        }
    }

    @Test(expected = ExistStorageException.class)
    public void saveResumeExistException() throws Exception {
        storage.save(resumeTest2);
    }

    @Test
    public void get() {
        Assert.assertEquals(resumeTest2, storage.get(resumeTest2.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistException() {
        storage.get(resumeTestNew.getUuid());
    }

    @Test
    public void delete() throws Exception {
        storage.delete(resumeTest3.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistException() throws Exception {
        storage.delete(resumeTestNew.getUuid());
    }

    @Test
    public void getAll() {
        Assert.assertArrayEquals(new Resume[]{resumeTest1, resumeTest2, resumeTest3}, storage.getAll());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistsException() throws Exception {
        storage.get("dummy");
    }
}