package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
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
        Role adminRole = Role.builder().roleName(Role.RoleName.ADMIN).build();
        roleService.add(adminRole);

        Role userRole = Role.builder().roleName(Role.RoleName.USER).build();
        roleService.add(userRole);

        userService.add(User.builder().email("admin@gmail.com")
                .password("Admin!1234").roles(Set.of(adminRole)).build());

        userService.add(User.builder().email("bob@gmail.com")
                .password("Bob!1234").roles(Set.of(userRole)).build());
    }
}
