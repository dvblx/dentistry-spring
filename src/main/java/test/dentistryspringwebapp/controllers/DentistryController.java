package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.DentistryDAO;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.Dentistry;

@Controller
@RequestMapping("/dentistry")
public class DentistryController implements  ControllerInterface{

    private final DentistryDAO dentistryDAO;

    @Autowired
    public DentistryController(DentistryDAO dentistryDAO) {this.dentistryDAO = dentistryDAO;}

    @GetMapping()
    public String getAll(Model model){
        return "dentistry/";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        return "dentistry/";
    }

    @GetMapping("/new")
    public String addNew(Model model){
        return "dentistry/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("dentist") Dentistry dentistry){

        return "redirect:/dentistry";
    }
}
