package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.DentistryDAO;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.Dentistry;

import javax.validation.Valid;

@Controller
@RequestMapping("/dentistry")
public class DentistryController{

    private final DentistryDAO dentistryDAO;

    @Autowired
    public DentistryController(DentistryDAO dentistryDAO) {this.dentistryDAO = dentistryDAO;}

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("dentistry", dentistryDAO.index());
        return "dentistry/";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        model.addAttribute("dentistry", dentistryDAO.show(id));
        return "dentistry/";
    }

    @GetMapping("/new")
    public String addNew(Model model, @ModelAttribute("dentistry") Dentistry dentistry){
        return "dentistry/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("dentist") Dentistry dentistry){

        return "redirect:/dentistry";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("dentistry", dentistryDAO.show(id));
        return "dentistry/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Dentistry dentistry, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/dentistry/edit";
        dentistryDAO.update(id, dentistry);
        return "redirect:/dentistry/";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        dentistryDAO.delete(id);
        return "redirect:/dentistry/";
    }
}
