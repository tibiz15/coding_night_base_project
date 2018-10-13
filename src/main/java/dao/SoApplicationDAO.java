package dao;

import entyties.SoApplication;

import java.util.List;

public interface SoApplicationDAO {
    SoApplication getSoApplication(int id);

    int insert(SoApplication soApplication);

    void update(SoApplication soApplication);

    boolean remove(SoApplication soApplication);


    List<SoApplication> getAll();
}
