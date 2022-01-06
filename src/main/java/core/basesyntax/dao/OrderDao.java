package core.basesyntax.dao;

import core.basesyntax.model.Order;
import core.basesyntax.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getByUser(User user);
}
