package codegym.vn.repository;

import codegym.vn.entity.User;

import java.util.List;

public interface IUserRepository {
    public List<User> findAllUser();
}
