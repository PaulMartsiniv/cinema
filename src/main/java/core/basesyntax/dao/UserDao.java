package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
