package services.impl;

import dao.UserDAO;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserByName(String name) {
        return userDAO.getByName(name);
    }
}
