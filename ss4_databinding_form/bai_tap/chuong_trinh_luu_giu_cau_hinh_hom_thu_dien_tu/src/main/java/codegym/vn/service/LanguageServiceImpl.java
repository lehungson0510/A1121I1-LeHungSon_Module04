package codegym.vn.service;

import codegym.vn.repository.ILanguageRepo;
import codegym.vn.repository.LanguageRepoImpl;

import java.util.List;

public class LanguageServiceImpl implements ILanguageService{

    ILanguageRepo languageRepo = new LanguageRepoImpl();
    @Override
    public List<String> languageList() {
        return languageRepo.languageList();
    }
}
