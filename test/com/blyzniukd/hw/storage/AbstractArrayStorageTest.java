package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.StorageException;
import com.blyzniukd.hw.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static com.blyzniukd.hw.storage.AbstractArrayStorage.STORAGE_LIMIT;


public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverloadException() throws Exception {
        try {
            for (int i = storage.size(); i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name " + i));
            }
        } catch (Exception ex) {
            Assert.fail("Some error appeared.");
        }
        storage.save(new Resume("Overflow"));
    }

}
