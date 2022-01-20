package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void inject() {
        Role adminRole = Role.builder().name(Role.RoleName.ADMIN).build();
        roleService.add(adminRole);

        Role userRole = Role.builder().name(Role.RoleName.USER).build();
        roleService.add(userRole);

        Set<Role> roleAdmin = new HashSet<>();
        roleAdmin.add(adminRole);
        User userAdmin = User.builder().email("admin@gmail.com")
                .password("Admin!1234").roles(roleAdmin).build();
        userService.add(userAdmin);

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(userRole);
        User user = User.builder().email("user@gmail.com")
                .password("Bob!1234").roles(rolesUser).build();
        userService.add(user);
    }
}
