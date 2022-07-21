package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.User;
import son.codegym.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
