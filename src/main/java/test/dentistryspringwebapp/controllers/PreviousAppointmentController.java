package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dentistryspringwebapp.dao.PreviousAppointmentDAO;
import test.dentistryspringwebapp.models.PreviousAppointment;

@Controller
@RequestMapping("/previous-appointments")
public class PreviousAppointmentController{

    private final PreviousAppointmentDAO previousAppointmentDAO;

    @Autowired
    public PreviousAppointmentController(PreviousAppointmentDAO previousAppointmentDAO) {this.previousAppointmentDAO = previousAppointmentDAO;}

    @GetMapping()
    public String getAll(Model model) {
        return "prevappointment/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        return "prevappointment/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "prevappointment/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("appointment") PreviousAppointment appointment){

        return "redirect:/previous-appointments";
    }

}
