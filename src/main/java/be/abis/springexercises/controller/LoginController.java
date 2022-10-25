package be.abis.springexercises.controller;

import be.abis.springexercises.model.Login;
import be.abis.springexercises.model.Person;
import be.abis.springexercises.service.PersonService;
import be.abis.springexercises.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private TrainingService ts;


    @GetMapping("/login")
    public String login(Model model){
       Login login = new Login();
       model.addAttribute("login", login);
       return "login";
    }

    @PostMapping("/login")
    public String showUser(Model model, Login login){
        Person p = ts.getPs().findPerson(login.getEmail(), login.getPassword());

        model.addAttribute("firstName", p.getFirstName());
        model.addAttribute("lastName", p.getLastName());
        return "greetUser";
    }


}

