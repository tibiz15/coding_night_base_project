package services.impl;

import dao.SoApplicationDAO;
import entyties.SoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import services.SkService;

import java.util.List;

public class SkServiceImpl implements SkService {

    @Autowired
    SoApplicationDAO soApplicationDAO;

    @Override
    public List<SoApplication> getUnroad() {
        return soApplicationDAO.getSkApplications();
    }

    @Override
    public void updateAplicatoion(SoApplication soApplication) {
        soApplicationDAO.update(soApplication);
    }
}
