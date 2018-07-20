package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.exception.StorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.blyzniukd.hw.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private final Resume UUID_1 = new Resume("uuid1");
    private final Resume UUID_2 = new Resume("uuid2");
    private final Resume UUID_3 = new Resume("uuid3");
    private final Resume UUID_NEW = new Resume("uuidNEW");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(UUID_1);
        storage.save(UUID_2);
        storage.save(UUID_3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
        Assert.assertArrayEquals(new Resume[0], storage.getAll());
    }

    @Test
    public void update() {
        storage.update(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateException() {
        storage.update(UUID_NEW);
    }

    @Test
    public void save() throws Exception {
        storage.save(UUID_NEW);
    }

    @Test
    public void get() {
        Assert.assertEquals(UUID_2, storage.get(UUID_2.getUuid()));
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_3.getUuid());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(UUID_1, storage.getAll()[0]);
        Assert.assertEquals(UUID_2, storage.getAll()[1]);
        Assert.assertEquals(UUID_3, storage.getAll()[2]);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistsException() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void checkOverloadException() throws Exception {
        try {
            for (int i = storage.size() - 1; i <= STORAGE_LIMIT; i++) {
                storage.save(new Resume());
//                Check the rule of StorageException
//                if (i > 100) {
//                    throw new Exception("Some other Exception");
//                }
            }
        } catch (StorageException ex) {
            if (storage.size() != STORAGE_LIMIT) {
                Assert.fail();
            } else {
                throw ex;
            }
        }
    }
}