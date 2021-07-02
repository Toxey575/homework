import java.util.List;

public interface Dao<T> {
        void add(T entity);
        List<T> getAll();
        void update(T entity);

    }


