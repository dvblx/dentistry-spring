package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dentistryspringwebapp.dao.ForthcomingAppointmentDAO;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

@Controller
@RequestMapping("/forthcoming-appointments")
public class ForthcomingAppointmentController implements ControllerInterface{

    private final ForthcomingAppointmentDAO forthcomingAppointmentDAO;

    @Autowired
    public ForthcomingAppointmentController(ForthcomingAppointmentDAO forthcomingAppointmentDAO) {this.forthcomingAppointmentDAO = forthcomingAppointmentDAO;}

    @GetMapping()
    public String getAll(Model model) {
        return "forthappointment/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        return "forthappointment/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "forthappointment/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("appointment") ForthcomingAppointment appointment){

        return "redirect:/forthcoming-appointments";
    }
}
