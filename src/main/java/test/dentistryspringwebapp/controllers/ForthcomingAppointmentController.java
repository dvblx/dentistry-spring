package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.ForthcomingAppointmentDAO;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import javax.validation.Valid;

@Controller
@RequestMapping("/forthcoming-appointments")
public class ForthcomingAppointmentController{

    private final ForthcomingAppointmentDAO forthcomingAppointmentDAO;

    @Autowired
    public ForthcomingAppointmentController(ForthcomingAppointmentDAO forthcomingAppointmentDAO) {this.forthcomingAppointmentDAO = forthcomingAppointmentDAO;}

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("appointments", forthcomingAppointmentDAO.index());
        return "forthappointment/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        model.addAttribute("appointment", forthcomingAppointmentDAO.show(id));
        return "forthappointment/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "forthappointment/new";
    }

    @PostMapping()
    public String creation(@ModelAttribute("appointment") @Valid ForthcomingAppointment appointment, BindingResult bindingResult){
        if (bindingResult.hasErrors()){return "forthappointment/new";}
        forthcomingAppointmentDAO.save(appointment);
        return "redirect:/forthcoming-appointments";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("appointment", forthcomingAppointmentDAO.show(id));
        return "forthappointment/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("appointment") @Valid ForthcomingAppointment appointment, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){return "forthappointment/edit";}
        forthcomingAppointmentDAO.update(id, appointment);
        return "redirect:/forthcoming-appointments";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        forthcomingAppointmentDAO.delete(id);
        return "redirect:/forthcoming-appointments";
    }
}
