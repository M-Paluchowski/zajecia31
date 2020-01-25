package org.javastart.zajecia31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/przelew")
    @ResponseBody
    public String hacked() {
        return "Twoje piniadze zostały przelane na konto atakującego";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "To jest panel administratora";
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {
        CreateUserForm form = new CreateUserForm();
        model.addAttribute("form", form);
        return "create";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute CreateUserForm form) {
        String username = form.getUsername();
        String password = form.getPassword();
        userService.saveUser(username, password);
        return "redirect:/";
    }

    @GetMapping("/activity")
    public String doActivity(Principal principal) {
        System.out.println(principal.getName());
        return "redirect:/";
    }
}
