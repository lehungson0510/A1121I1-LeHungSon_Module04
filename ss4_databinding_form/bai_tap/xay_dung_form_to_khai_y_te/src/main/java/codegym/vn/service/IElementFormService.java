package codegym.vn.service;

import codegym.vn.entity.MedicalForm;

import java.util.List;
import java.util.Map;

public interface IElementFormService {
    List<String> genderList ();
    List<String> nationalityList ();
    List<String> travelInfoList ();
    Map<String, String> checkData(MedicalForm medicalForm);
}
