package test.dentistryspringwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.dentistryspringwebapp.dao.TimeTableDAO;
import test.dentistryspringwebapp.models.Dentistry;
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
        if (bindingResult.hasErrors()){return "timetable/new";}
        timeTableDAO.save(timeTable);
        return "redirect:/timetable";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("timetable", timeTableDAO.show(id));
        return "/timetable/timetable_edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("dentistry") @Valid TimeTable tt, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){ return "/timetable/timetable_edit";}
        timeTableDAO.update(id, tt);
        return "redirect:/timetable";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        timeTableDAO.delete(id);
        return "redirect:/timetable";
    }
}
