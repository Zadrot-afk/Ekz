package com.example.demo_.controllers;
import jakarta.validation.Valid;
import com.example.demo_.models.Identity.AppUser;
import com.example.demo_.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class RegistrationController {
    private final AppUserService _userService;



        @PostMapping("/registration")
        public String registerUser(@ModelAttribute("user") @Valid AppUser appUser, BindingResult bindingResult, Model model){
            if(bindingResult.hasErrors()){
            return "user/registration";

            }
            if(!appUser.getPassword().equals(appUser.getPasswordComfirm())){
                model.addAttribute("passwordError", "Invalid password");
            return "user/registration";
            }
            if(!_userService.registerUser(appUser)){
                model.addAttribute("usernameForm","Username already exists");
            return "user/registration";
            }
            return "user/login";
        }


}
