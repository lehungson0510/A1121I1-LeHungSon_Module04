package son.codegym.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import son.codegym.entity.Product;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getManufacturingDate() == null)
        {
            errors.rejectValue("manufacturingDate","StarTimeNotNull");
        }

        if (product.getOutOfDate() == null)
        {
            errors.rejectValue("outOfDate","EndTimeNotNull");
        }
        else
        {
            LocalDate startTime = product.getManufacturingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endTime = product.getOutOfDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(startTime,endTime).getDays() < 0)
            {
                errors.rejectValue("outOfDate","DateComparison");
            }
        }
    }
}
