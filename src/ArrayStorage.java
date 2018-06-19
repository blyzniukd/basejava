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
        if ( size < storage.length ) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        Resume answer = new Resume();
        for (int i = 0; i < size; i++){
            if (storage[i].uuid.equals(uuid)){
                answer = storage[i];
            }
        }
        return answer;
    }

    void delete(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++){
            if (storage[i].uuid.equals(uuid)){
                position = i;
            }
        }
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
