package core.basesyntax.dao;

import core.basesyntax.model.ShoppingCart;
import core.basesyntax.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
