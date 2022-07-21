package son.codegym.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import son.codegym.entity.Product;
import son.codegym.service.IProductService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProductFormatter implements Formatter<Product> {
    private IProductService service;
    @Autowired
    public ProductFormatter(IProductService service) {
        this.service = service;
    }
    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(Product object, Locale locale) {
        return object.toString();
    }
}
