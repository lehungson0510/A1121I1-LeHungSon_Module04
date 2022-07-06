package codegym.vn.service;

import codegym.vn.entity.MedicalForm;
import codegym.vn.repository.ElementFormRepoImpl;
import codegym.vn.repository.IElementFormRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFormServiceImpl implements IElementFormService{
    IElementFormRepo elementFormRepo = new ElementFormRepoImpl();

    @Override
    public List<String> genderList() {
        return elementFormRepo.genderList();
    }

    @Override
    public List<String> nationalityList() {
        return elementFormRepo.nationalityList();
    }

    @Override
    public List<String> travelInfoList() {
        return elementFormRepo.travelInfoList();
    }

    @Override
    public Map<String, String> checkData(MedicalForm medicalForm) {
        Map<String, String > mapError = new HashMap<>();
        if (medicalForm.getName().equals("")){
            mapError.put("name","Bạn chưa nhập mục này");
        }
        if (medicalForm.getBirthday().equals("")){
            mapError.put("birthday","Bạn chưa nhập mục này");
        }
        if (medicalForm.getIdCard().equals("")){
            mapError.put("idCard","Bạn chưa nhập mục này");
        }
        if (medicalForm.getTravelInfo()== null){
            mapError.put("travelInfo","Bạn chưa nhập mục này");
        }
        if (medicalForm.getNumberVehicle().equals("")){
            mapError.put("numberVehicle","Bạn chưa nhập mục này");
        }
        if (medicalForm.getNumberSeat().equals("")){
            mapError.put("numberSeat","Bạn chưa nhập mục này");
        }
        if (medicalForm.getDateStart().equals("")){
            mapError.put("dateStart","Bạn chưa nhập mục này");
        }
        if (medicalForm.getDateEnd().equals("")){
            mapError.put("dateEnd","Bạn chưa nhập mục này");
        }
        if (medicalForm.getExtraInfo().equals("")){
            mapError.put("extraInfo","Bạn chưa nhập mục này");
        }
        return mapError;
    }
}
