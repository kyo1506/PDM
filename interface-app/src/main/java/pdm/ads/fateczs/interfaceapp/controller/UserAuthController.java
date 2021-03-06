package pdm.ads.fateczs.interfaceapp.controller;

import pdm.ads.fateczs.interfaceapp.model.bean.UserAuth;
import pdm.ads.fateczs.interfaceapp.model.dao.UserAuthDAO;

import java.util.List;

public class UserAuthController {
    UserAuthDAO userAuthDAO = new UserAuthDAO();
    public void insertUser (UserAuth userAuth) {
        userAuthDAO.insertUser(userAuth);
    }
    public void updateUser (UserAuth userAuth) {
        userAuthDAO.updateUser(userAuth);
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
