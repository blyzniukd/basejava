import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if ( size+1 < 10000 ) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        Resume searchObj = new Resume(uuid);
        int position = Arrays.binarySearch(this.storage, 0, size, searchObj );

        if (position != -1){
            return storage[position];
        } else {
            return new Resume();
        }
    }

    void delete(String uuid) {
        Resume searchObj = new Resume(uuid);
        int position = Arrays.binarySearch(storage, 0, size, searchObj);
        if ( position != -1 ){
            System.arraycopy(storage, position + 1, storage, position, size - position);
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
