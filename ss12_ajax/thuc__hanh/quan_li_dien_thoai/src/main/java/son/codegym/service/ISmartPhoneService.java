package son.codegym.service;

import son.codegym.entity.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();

    // Để kiểm tra coi thử có hay không, hay dùng cho search các kiểu
    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
