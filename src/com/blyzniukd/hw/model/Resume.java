package com.blyzniukd.hw.model;

import com.blyzniukd.hw.model.contact.Contacts;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    // Id
    private final String uuid;
    private final String fullName;
    private Contacts contacts;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null.");
        Objects.requireNonNull(fullName, "fullName must not be null.");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode() + fullName.hashCode();
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public int compareTo(Resume resume) {
        int cmp = fullName.compareTo(resume.fullName);
        return (cmp != 0) ? cmp : uuid.compareTo(resume.uuid);
    }
}
