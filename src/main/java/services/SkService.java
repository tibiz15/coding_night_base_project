package services;

import entyties.SoApplication;

import java.util.List;

public interface SkService {

    List<SoApplication> getUnroad();

    void updateAplicatoion(SoApplication soApplication);
}
