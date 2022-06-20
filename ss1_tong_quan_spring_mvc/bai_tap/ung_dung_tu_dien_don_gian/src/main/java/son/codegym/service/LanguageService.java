package son.codegym.service;

import son.codegym.repository.ILanguageRepo;
import son.codegym.repository.LanguageRepoImpl;

public class LanguageService implements ILanguageService {
    ILanguageRepo languageRepo = new LanguageRepoImpl();

    @Override
    public String translate(String language) {
        return languageRepo.translate(language);
    }
}
