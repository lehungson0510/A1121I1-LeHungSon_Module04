package son.codegym.repository;

import son.codegym.entity.Language;

import java.util.ArrayList;
import java.util.List;

public class LanguageRepoImpl implements ILanguageRepo {
    private static List<Language> languageList = new ArrayList<>();

    static {
        languageList.add(new Language("one", "1"));
        languageList.add(new Language("two", "2"));
        languageList.add(new Language("three", "3"));
        languageList.add(new Language("four", "4"));
        languageList.add(new Language("five", "5"));
        languageList.add(new Language("six", "6"));
        languageList.add(new Language("seven", "7"));
        languageList.add(new Language("eight", "8"));
        languageList.add(new Language("nine", "9"));
        languageList.add(new Language("ten", "10"));
        languageList.add(new Language("student", "học sinh"));
        languageList.add(new Language("teacher", "giáo viên"));
        languageList.add(new Language("mom", "mẹ"));
        languageList.add(new Language("dad", "cha"));
        languageList.add(new Language("son", "con trai"));
        languageList.add(new Language("daughter", "con gái"));
    }

    @Override
    public String translate(String language) {
        for (Language language1 : languageList) {
            if (language.equalsIgnoreCase(language1.getEnglish())) {
                return language1.getVietnamese();
            }
        }
        return "";
    }
}
