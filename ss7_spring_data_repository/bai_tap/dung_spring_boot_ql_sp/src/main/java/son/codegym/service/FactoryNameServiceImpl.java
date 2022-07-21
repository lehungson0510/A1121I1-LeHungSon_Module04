package son.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.codegym.entity.Factory;
import son.codegym.repository.FactoryNameRepo;

import java.util.List;

@Service
public class FactoryNameServiceImpl implements IFactoryNameService {
    @Autowired
    FactoryNameRepo repository;

    @Override
    public void create(Factory factory) {
        repository.save(factory);
    }

    @Override
    public void update(Factory factory) {
        repository.save(factory);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Factory> findAll() {
        return repository.findAll();
    }

    @Override
    public Factory findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
