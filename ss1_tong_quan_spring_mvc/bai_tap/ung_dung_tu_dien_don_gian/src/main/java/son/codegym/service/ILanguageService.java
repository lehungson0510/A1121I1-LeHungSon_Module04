package son.codegym.service;

import son.codegym.entity.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> findAll();

    String translate(String english);
}
