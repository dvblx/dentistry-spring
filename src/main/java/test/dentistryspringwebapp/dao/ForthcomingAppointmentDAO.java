package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import java.util.List;

public class ForthcomingAppointmentDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;
    @Autowired
    public ForthcomingAppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ForthcomingAppointment> index(){
        return null;
    }
    public List<Dentist> filtering(){
        return null;
    }

    public Dentist show(int id){
        return null;
    }
    public void save(Dentist dentist){

    }
    public void update(int id, Dentist updatedDentist){

    }
    public void delete(int id){

    }
}
