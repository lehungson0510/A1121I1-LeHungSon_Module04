package codegym.vn.service;

import codegym.vn.entity.Login;
import codegym.vn.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> findAllUser();
    public User checkLogin(Login login);
}
