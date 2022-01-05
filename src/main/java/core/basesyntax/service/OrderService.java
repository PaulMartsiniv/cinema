package core.basesyntax.service;

import core.basesyntax.model.Order;
import core.basesyntax.model.ShoppingCart;
import core.basesyntax.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
