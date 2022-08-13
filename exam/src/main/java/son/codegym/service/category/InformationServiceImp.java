package son.codegym.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import son.codegym.entity.Information;
import son.codegym.repository.IInformationRepo;

@Service
public class InformationServiceImp implements IInformationService {
    @Autowired
    IInformationRepo informationRepo;
    @Override
    public void create(Information information) {
        informationRepo.save(information);
    }

    @Override
    public void delete(int id) {
        informationRepo.deleteById(id);
    }

    @Override
    public Page<Information> findAllSearch(String title, String category, Pageable pageable) {
        return informationRepo.findAndSearch("%"+title+"%","%"+category+"%",pageable);
    }

    @Override
    public Page<Information> findAll(Pageable pageable) {
        return informationRepo.findAll(pageable);
    }

    @Override
    public Information findById(int id) {
        return informationRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Information> search(String title, String category, Pageable pageable) {
        return informationRepo.findAndSearch(title,category,pageable);
    }
}
