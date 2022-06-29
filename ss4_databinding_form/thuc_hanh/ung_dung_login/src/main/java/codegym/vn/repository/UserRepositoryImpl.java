package codegym.vn.repository;

import codegym.vn.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private static List<User> userList;
    static {
        userList = new ArrayList<>();
        User u1 = new User();
        u1.setAge(23);
        u1.setName("son");
        u1.setAccount("son");
        u1.setEmail("son@codegym.vn");
        u1.setPassword("123456");
        userList.add(u1);

        User u2 = new User();
        u2.setAge(25);
        u2.setName("huy");
        u2.setAccount("huy");
        u2.setEmail("huy@codegym.vn");
        u2.setPassword("123456");
        userList.add(u2);

        User u3 = new User();
        u3.setAge(24);
        u3.setName("truong");
        u3.setAccount("truong");
        u3.setEmail("truong@codegym.vn");
        u3.setPassword("123456");
        userList.add(u3);
    }
    @Override
    public List<User> findAllUser() {
        return userList;
    }
}
