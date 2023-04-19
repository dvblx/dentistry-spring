package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.DentistDAO;
import test.dentistryspringwebapp.models.Dentist;

@Controller
@RequestMapping("/dentists")
public class DentistController implements ControllerInterface{

    private final DentistDAO dentistDAO;

    @Autowired
    public DentistController(DentistDAO dentistDAO) {this.dentistDAO = dentistDAO;}

    @GetMapping()
    public String getAll(Model model){
        return "dentist/";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        return "dentist/";
    }

    @GetMapping("/new")
    public String addNew(Model model){
        return "dentist/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("dentist") Dentist dentist){

        return "redirect:/dentists";
    }
}
