package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import son.codegym.entity.SmartPhone;
import son.codegym.service.ISmartPhoneService;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneRestController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<SmartPhone> selectSmartPhone(@PathVariable("id") Long id) {
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(smartPhone.get(),HttpStatus.OK);
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<SmartPhone> updateSmartPhone(@PathVariable("id") Long id,@RequestBody SmartPhone smartPhone) {
        Optional<SmartPhone> phone = smartPhoneService.findById(id);
        if(!phone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            smartPhone.setId(phone.get().getId());
            return new ResponseEntity<>(smartPhoneService.save(smartPhone),HttpStatus.OK);
        }
    }

}
