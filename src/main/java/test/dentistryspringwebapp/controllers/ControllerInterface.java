package test.dentistryspringwebapp.controllers;

import org.springframework.ui.Model;

public interface ControllerInterface {
    String getAll(Model model);
    String getOne(int id, Model model);
    String addNew(Model model);
}
