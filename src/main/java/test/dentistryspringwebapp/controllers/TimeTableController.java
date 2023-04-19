package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dentistryspringwebapp.dao.TimeTableDAO;
import test.dentistryspringwebapp.models.TimeTable;

@Controller
@RequestMapping("/timetable")
public class TimeTableController implements ControllerInterface {

    private final TimeTableDAO timeTableDAO;

    @Autowired
    public TimeTableController(TimeTableDAO timeTableDAO) {this.timeTableDAO = timeTableDAO;}

    @GetMapping()
    public String getAll(Model model) {
        return "timetable/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        return "timetable/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "timetable/";
    }

    @PostMapping()
    public String creation(@ModelAttribute("timetable") TimeTable timeTable){

        return "redirect:/timetable";
    }
}
