package son.codegym.service;

import son.codegym.entity.Language;
import son.codegym.repository.ILanguageRepo;
import son.codegym.repository.LanguageRepoImpl;

import java.util.List;

public class LanguageService implements ILanguageService {
    ILanguageRepo languageRepo = new LanguageRepoImpl();

    @Override
    public List<Language> findAll() {
        return languageRepo.findAll();
    }

    @Override
    public String translate(String english) {
        List<Language> languageList = findAll();
        for (Language language : languageList){
            if(english.equalsIgnoreCase(language.getEnglish())){
                return language.getVietnamese();
            }
        }
        return "";
    }
}
