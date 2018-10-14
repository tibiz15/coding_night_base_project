package services;

import entyties.SoApplication;
import entyties.User;

import java.util.List;

public interface DecanService {

    List<SoApplication> getUnroad();

    void updateApplication(SoApplication soApplication);
}

