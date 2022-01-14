package cinema.service.impl;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Override
    public User register(String email, String password) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName(Role.RoleName.USER.name()));
        User user = User.builder().email(email).password(password).roles(roles).build();
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
