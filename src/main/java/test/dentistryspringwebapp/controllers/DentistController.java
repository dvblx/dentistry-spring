package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.DentistDAO;
import test.dentistryspringwebapp.models.Dentist;

@Controller
@RequestMapping("/dentists")
public class DentistController{

    private final DentistDAO dentistDAO;

    @Autowired
    public DentistController(DentistDAO dentistDAO) {this.dentistDAO = dentistDAO;}

    @GetMapping()
    public String getAll(Model model, @RequestParam(value = "dentistry", required = false) String dentistry,
                         @RequestParam(value = "dentist_type", required = false) String dentist_type){
        model.addAttribute("dentists", dentistDAO.filtering(dentistry, dentist_type));
        return "dentist/";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        model.addAttribute("dentist", dentistDAO.show(id));
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
