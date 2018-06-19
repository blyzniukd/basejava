/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable<Resume>{

    // Unique identifier
    String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume arg0) {

        return toString().compareTo(arg0.toString());
    }
}
