package dao;

import model.User;

import model.Role;
import java.util.List;

public interface UserDAO {
    User add(User user);

    User getById(int id);

    List getAllUser();

    User updateUser(User user);

    void deleteUser(User user);

    void addRoleToUser(User user, Role role);
}
