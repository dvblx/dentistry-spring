package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.DentistDAO;
import test.dentistryspringwebapp.dao.TimeTableDAO;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.Dentistry;

import javax.validation.Valid;

@Controller
@RequestMapping("/dentists")
public class DentistController{

    private final DentistDAO dentistDAO;
    private final TimeTableDAO timeTableDAO;

    @Autowired
    public DentistController(DentistDAO dentistDAO, TimeTableDAO timeTableDAO) {
        this.dentistDAO = dentistDAO;
        this.timeTableDAO = timeTableDAO;
    }

    @GetMapping()
    public String getAll(Model model, @RequestParam(value = "dentistry", required = false) String dentistry,
                         @RequestParam(value = "dentist_type", required = false) String dentist_type){
        model.addAttribute("dentists", dentistDAO.filtering(dentistry, dentist_type));
        return "dentist/all_dentists";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){
        model.addAttribute("dentist", dentistDAO.show(id));
        model.addAttribute("timetable", timeTableDAO.filtering(null, dentistDAO.show(id).getDentist_name(), null));
        return "dentist/one_dentist";
    }

    @GetMapping("/new")
    public String addNew(Model model){
        return "dentist/new_dentist";
    }

    @PostMapping()
    public String creation(@ModelAttribute("dentist") @Valid Dentist dentist, BindingResult bindingResult){
        if (bindingResult.hasErrors()){return "dentist/new_dentist";}
        dentistDAO.save(dentist);
        return "redirect:/dentists";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("dentist", dentistDAO.show(id));
        return "dentistry/edit_dentist";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("dentist") @Valid Dentist dentist, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){ return "/dentist/edit_dentist";}
        dentistDAO.update(id, dentist);
        return "redirect:/dentistry";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        dentistDAO.delete(id);
        return "redirect:/dentists";
    }
}
