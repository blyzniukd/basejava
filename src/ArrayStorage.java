import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (this.checkUuid(r.getUuid()) == -1) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("The array is full. Try to delete element from array before save.");
            }
        } else {
            System.out.println(" Resume with same UUID[" + r.getUuid() + "] is exist.");
        }
    }

    public Resume get(String uuid) {
        int position = this.checkUuid(uuid);
        if (position != -1) {
            return storage[position];
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
            return null;
        }
    }

    public void delete(String uuid) {
        int position = this.checkUuid(uuid);
        if (position != -1) {
            System.arraycopy(storage, position + 1, storage, position, size - position);
            size--;
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
        }
    }

    public boolean update(Resume resume) {
        int position = this.checkUuid(resume.getUuid());
        if (position != -1){
            this.storage[position] = resume;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int checkUuid(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                position = i;
            }
        }
        return position;
    }
}
