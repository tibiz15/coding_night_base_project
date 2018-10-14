package dao;

import entyties.SoApplication;

import java.util.List;

public interface SoApplicationDAO {
    SoApplication getSoApplication(int id);

    int insert(SoApplication soApplication);

    void update(SoApplication soApplication);

    void remove(SoApplication soApplication);

    List<SoApplication> getSkApplications();

    List<SoApplication> getDecanApplications();

    List<SoApplication> getAll();
}
