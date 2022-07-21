package son.codegym.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.User;

public class UserValidation implements Validator {
    String a;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
//        if (user.getPhoneNumber().length() != 10) {
//            errors.rejectValue("phoneNumber", "phoneNumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
//        } else if (!user.getPhoneNumber().startsWith("0")) {
//            errors.rejectValue("phoneNumber", "phoneNumberStart",new String[]{"0"}, "Số điện thoại không đúng định dạng");
//        }
        if (!user.getEmail().matches("^[a-z]\\w*@gmail+\\.[a-z]+$")){
            errors.rejectValue("email", "email", "Email không đúng định dạng");
        }
        if (!user.getPhoneNumber().matches("^090\\d{7}$|^091\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$")){
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không đúng định dạng");
        }
    }
}
