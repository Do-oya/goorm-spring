package spring.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.springhello.service.LoggedUserManagementService;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String mainPage() {
        String userName = loggedUserManagementService.getUserName();

        if (userName == null) {
            return "redirect:/login";
        }

        return "main";
    }
}
