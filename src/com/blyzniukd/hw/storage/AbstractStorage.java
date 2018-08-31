package com.blyzniukd.hw.storage;

import com.blyzniukd.hw.exception.ExistStorageException;
import com.blyzniukd.hw.exception.NotExistStorageException;
import com.blyzniukd.hw.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract Object getSearcheKey(String uuid);

    protected abstract Resume doGet(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract void doSave(Object searchKey, Resume resume);

    protected abstract void doDelete(Object searchKey);

    protected abstract List<Resume> doCopyAll();

    public void update(Resume resume) {
        Object searchKey = getExistedKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume.getUuid());
        Object searchKey = getNotExistedKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        Object searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> copyList = doCopyAll();
        Collections.sort(copyList);
        return copyList;
    }

    private Object getExistedKey(String uuid) {
        Object searchKey = getSearcheKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exists.");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedKey(String uuid) {
        Object searchKey = getSearcheKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exists.");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }


}
