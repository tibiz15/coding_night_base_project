package dao;

import entyties.User;

import java.util.List;

public interface UserDAO {
    User get(int id);

    User getByName(String name);

    int insert(User user);

    void update(User user);

    void remove(User user);

    List<User> getAll();
}
