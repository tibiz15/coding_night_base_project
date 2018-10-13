package dao;

import entyties.SO;

import java.util.List;

public interface SoDAO {
    SO get(int id);

    int insert(SO so);

    void update(SO so);

    boolean remove(SO so);

    List<SO> getAll();

}
