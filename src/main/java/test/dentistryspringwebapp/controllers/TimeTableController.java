package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.TimeTableDAO;
import test.dentistryspringwebapp.models.TimeTable;

import javax.validation.Valid;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {

    private final TimeTableDAO timeTableDAO;

    @Autowired
    public TimeTableController(TimeTableDAO timeTableDAO) {this.timeTableDAO = timeTableDAO;}

    @GetMapping()
    public String getAll(Model model, @RequestParam(value = "dentistry", required = false) String dentistry,
                         @RequestParam(value = "dentist", required = false) String dentist,
                         @RequestParam(value = "day", required = false) String day) {
        model.addAttribute("timetable", timeTableDAO.filtering(dentistry, dentist, day));
        return "timetable/";
    }

    @GetMapping("/{id}")
    public String getOne(int id, Model model) {
        return "timetable/";
    }

    @GetMapping("/new")
    public String addNew(Model model) {
        return "timetable/new";
    }

    @PostMapping()
    public String creation(@ModelAttribute("timetable") @Valid TimeTable timeTable, BindingResult bindingResult){

        return "redirect:/timetable";
    }
}
