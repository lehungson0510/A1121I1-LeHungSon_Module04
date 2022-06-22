package son.codegym.repository;

import son.codegym.entity.Language;

import java.util.List;

public interface ILanguageRepo {
    List<Language> findAll();
}
