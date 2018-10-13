package dao;

import entyties.User;

import java.util.List;

public interface UserDAO {
    User get(int id);

    int insert(User user);

    void update(User user);

    boolean remove(User user);

    boolean ifExists(User user);

    List<User> getAll();
}
