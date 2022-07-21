package son.codegym.service;

import son.codegym.entity.Factory;

import java.util.List;

public interface IFactoryNameService {
    void create(Factory factory);
    void update(Factory factory);
    void delete(int id);
    List<Factory> findAll();
    Factory findById(int id);
}
