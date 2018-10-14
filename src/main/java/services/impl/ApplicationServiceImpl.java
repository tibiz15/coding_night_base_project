package services.impl;

import dao.SoApplicationDAO;
import dao.UserDAO;
import entyties.SoApplication;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.ApplicationService;


@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {


    @Autowired
    SoApplicationDAO soApplicationDAO;

    @Override
    public int insertApplication(SoApplication soApplication) {
        return soApplicationDAO.insert(soApplication);
    }
}
