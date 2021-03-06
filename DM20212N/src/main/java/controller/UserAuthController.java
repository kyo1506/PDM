package controller;

import model.bean.UserAuth;
import model.dao.UserAuthDAO;

import java.util.List;

public class UserAuthController {
    UserAuthDAO userAuthDAO = new UserAuthDAO();

    public void insertOrUpdate (UserAuth userAuth) {
        userAuthDAO.insertOrUpdate(userAuth);
    }

    public UserAuth getById (Long id)
    {
        return userAuthDAO.getById(id);
    }

    public UserAuth getByName (String username)
    {
        return userAuthDAO.getByName(username);
    }

    public List<UserAuth> listAll () {
        return userAuthDAO.listAll();
    }

    public void deleteById (Long id) {
        userAuthDAO.deleteById(id);
    }
}
