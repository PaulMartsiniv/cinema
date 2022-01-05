package core.basesyntax.service.impl;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.lib.Service;
import core.basesyntax.model.Order;
import core.basesyntax.model.ShoppingCart;
import core.basesyntax.model.User;
import core.basesyntax.service.OrderService;
import core.basesyntax.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order(LocalDateTime.now(), shoppingCart.getUser());
        order.setTickets(shoppingCart.getTickets());
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
