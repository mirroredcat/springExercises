package be.abis.springexercises.controller;

import be.abis.springexercises.model.Person;
import be.abis.springexercises.service.PersonService;
import be.abis.springexercises.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired private TrainingService tr;

    @GetMapping("/{id}")
    public String home (Model model, @PathVariable int id){
        Person p = tr.getPs().findPerson(3);
        model.addAttribute("message", tr.getCs().findCourse(id).getShortTitle());
        model.addAttribute("sayHello", p.getFirstName() + " " + p.getLastName() );
        return "home";
    }



    /*

    @RestController above the class name

    @GetMapping("/{id})
    public Course printCourse(Model model, @PathVariable int id){
        Course c = tr.getCs().findCourse(id);
        return c;
    }

    ^this returns json in the web page
     */

}
