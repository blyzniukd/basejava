/**
 * com.urise.webapp.model.Resume class
 */
public class Resume {

    // Unique identifier
    // по хорошему должен быть private с  доступом  через геттер
    String uuid;

    @Override
    public String toString() {
        return uuid;
    }

}
