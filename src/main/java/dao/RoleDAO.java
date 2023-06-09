package dao;

import javax.management.relation.Role;
import java.util.List;

public interface RoleDAO {
    Role add (Role role);
    Role getById(int id);
    List<Role> getAllRoles();
    void deleteRole(Role role);
}
