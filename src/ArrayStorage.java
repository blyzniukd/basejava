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
        if (size < storage.length) {
            if (checkUuid(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println(" Resume with same UUID[" + r.getUuid() + "] is exist.");
            }
        } else {
            System.out.println("The array is full. Try to delete element from array before save.");
        }
    }

    public Resume get(String uuid) {
        int position = checkUuid(uuid);
        if (position != -1) {
            return storage[position];
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
            return null;
        }
    }

    public void delete(String uuid) {
        int position = checkUuid(uuid);
        if (position != -1) {
            storage[position] = storage[size];
            storage[size] = null;
            size--;
        } else {
            System.out.println("Resume object with UUID[" + uuid + "] is not exist.");
        }
    }

    public void update(Resume resume) {
        int position = checkUuid(resume.getUuid());
        if (position != -1){
            storage[position] = resume;
        } else {
            System.out.println("Resume object with UUID[" + resume.getUuid() + "] is not exist.");
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
