package cinema.dao;

import cinema.model.Role;
import java.util.Optional;

public interface RoleDao extends GenericDao<Role> {
    Optional<Role> getByName(String roleName);
}
