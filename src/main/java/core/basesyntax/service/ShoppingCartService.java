package core.basesyntax.service;

import core.basesyntax.model.MovieSession;
import core.basesyntax.model.ShoppingCart;
import core.basesyntax.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
