package codegym.vn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String home() {
        return "home";
    }

    @PostMapping("/calculator")
    public String home(Model model, @RequestParam("calculation") String calculation, @RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        switch (calculation) {
            case "+":
                model.addAttribute("result", num1 + num2);
                model.addAttribute("calculation", "Result Addition: ");
                break;
            case "-":
                model.addAttribute("result", num1 - num2);
                model.addAttribute("calculation", "Result Subtraction: ");
                break;
            case "*":
                model.addAttribute("result", num1 * num2);
                model.addAttribute("calculation", "Result Multiplication: ");
                break;
            case "/":
                if (num2 == 0) {
                    model.addAttribute("result", "Result Division: error");
                    model.addAttribute("message", "Invalid");
                } else {
                    model.addAttribute("result", num1 / num2);
                    model.addAttribute("calculation", "Result Multiplication:");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        model.addAttribute("number1", num1);
        model.addAttribute("number2", num2);
        return "home";
    }

}
