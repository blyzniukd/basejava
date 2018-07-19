package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.exception.StorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final int STORAGE_LIMIT = 100_000;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_NEW = "uuidNEW";


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
        Assert.assertArrayEquals(new Resume[0], storage.getAll());
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_NEW));
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_3);
    }

    @Test
    public void getAll() throws IllegalAccessException, InstantiationException {
        final Storage storage_expexted = storage.getClass().newInstance();
        storage_expexted.save(new Resume(UUID_1));
        storage_expexted.save(new Resume(UUID_2));
        storage_expexted.save(new Resume(UUID_3));
        Assert.assertArrayEquals(storage_expexted.getAll(), storage.getAll());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExists() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void getExists() throws Exception {
        try {
            for (int i = storage.size(); i <= STORAGE_LIMIT; i++) {
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