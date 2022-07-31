package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import son.codegym.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }

    @RequestMapping("/login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser",defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }

                Cookie cookie = new Cookie("setUser", setUser);

//             Thời gian tính theo giấy
                cookie.setMaxAge(24 * 60 * 60);

                response.addCookie(cookie);

                // lấy tất cả cookie
                Cookie[] cookies = request.getCookies();

                for (Cookie ck : cookies) {
                    if (ck.getName().equals("setUser")) {
                        model.addAttribute("cookieValue", ck);
                        break;
                    } else {
                        ck.setValue("");
                        model.addAttribute("cookieValue", ck);
                        break;
                    }
                }
                model.addAttribute("message", "Login success. Welcome ");
            } else {
                user.setEmail("");
                Cookie cookie = new Cookie("setUser", setUser);
                model.addAttribute("cookieValue", cookie);
                model.addAttribute("message", "Login failed. Try again.");
            }
        return "/login";
    }
}
