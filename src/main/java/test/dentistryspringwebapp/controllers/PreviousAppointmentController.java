package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.PreviousAppointmentDAO;
import test.dentistryspringwebapp.models.ForthcomingAppointment;
import test.dentistryspringwebapp.models.PreviousAppointment;

import javax.validation.Valid;

@Controller
@RequestMapping("/previous-appointments")
public class PreviousAppointmentController{

    private final PreviousAppointmentDAO previousAppointmentDAO;

    @Autowired
    public PreviousAppointmentController(PreviousAppointmentDAO previousAppointmentDAO) {this.previousAppointmentDAO = previousAppointmentDAO;}

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("appointments", previousAppointmentDAO.index());
        return "prevappointment/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        model.addAttribute("appointment", previousAppointmentDAO.show(id));
        return "prevappointment/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "prevappointment/new";
    }

    @PostMapping()
    public String creation(@ModelAttribute("appointment") @Valid PreviousAppointment appointment, BindingResult bindingResult){
        if (bindingResult.hasErrors()){return "prevappointment/new";}
        previousAppointmentDAO.save(appointment);
        return "redirect:/previous-appointments";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("appointment", previousAppointmentDAO.show(id));
        return "prevappointment/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("appointment") @Valid PreviousAppointment appointment, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){return "prevappointment/edit";}
        previousAppointmentDAO.update(id, appointment);
        return "redirect:/previous-appointments";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        previousAppointmentDAO.delete(id);
        return "redirect:/previous-appointments";
    }

}
