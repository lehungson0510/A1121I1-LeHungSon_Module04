package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Information;

public class ValidationInformation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Information.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Information information = (Information) target;

    if (information.getCategoryId() == null){
        errors.rejectValue("categoryId", "type");
    }

    if (information.getDate() == null){
        errors.rejectValue("date","type");
    }

//       else  {
//            LocalDate startTime = information.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            LocalDate endTime = LocalDate.now();
//        System.out.println(endTime);
//            if (Period.between(startTime,endTime).getDays() < 0)
//            {
//                errors.rejectValue("date","dateComparison");
//            }
//        }
    }
}
