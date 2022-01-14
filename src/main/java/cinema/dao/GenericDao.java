package cinema.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    T add(T t);

    Optional<T> get(Long id);

    List<T> getAll();

    T update(T t);

    void delete(Long id);
}
