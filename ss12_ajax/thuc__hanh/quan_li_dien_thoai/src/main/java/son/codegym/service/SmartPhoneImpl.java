package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.SmartPhone;
import son.codegym.repo.ISmartPhoneRepo;

import java.util.Optional;

@Service
public class SmartPhoneImpl implements ISmartPhoneService {
    @Autowired
    ISmartPhoneRepo smartPhoneRepo;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepo.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepo.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepo.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepo.deleteById(id);
    }
}
