package son.codegym.service;

import org.springframework.stereotype.Service;
import son.codegym.entity.User;

public interface IUserService {
    void save(User user);
}
