package core.basesyntax.security;

import core.basesyntax.exception.AuthenticationException;
import core.basesyntax.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
