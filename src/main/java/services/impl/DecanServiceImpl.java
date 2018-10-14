package services.impl;

import dao.SoApplicationDAO;
import dao.SoDAO;
import dao.UserDAO;
import entyties.SO;
import entyties.SoApplication;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.DecanService;

import java.util.List;

@Service
@Transactional
public class DecanServiceImpl implements DecanService {

    @Autowired
    SoApplicationDAO soApplicationDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    SoDAO soDAO;

    @Override
    public List<SoApplication> getUnroad() {
        return soApplicationDAO.getDecanApplications();
    }

    @Override
    public void updateApplication(SoApplication soApplication) {
        if (soApplication.isApproved()) soDAO.insert(createSO(soApplication));
        soApplicationDAO.update(soApplication);
    }

    private SO createSO(SoApplication soApplication) {
        User author = userDAO.get(soApplication.getAuthorID());
        SO so = new SO(soApplication.getApplicationID(), soApplication.getName(), soApplication.getDescription(),
                soApplication.getAim(), author.getName(), author.getTel_num(), author.getEmail());
        return so;
    }
}
