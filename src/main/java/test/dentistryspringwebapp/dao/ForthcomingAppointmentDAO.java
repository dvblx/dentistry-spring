package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.FAMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ForthcomingAppointmentDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    @Autowired
    public ForthcomingAppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ForthcomingAppointment> index(){
        SQLquery = "select appointments.appointment_id, dentistry.dentistry_id, dentistry.dentistry_name, " +
                "dentist.dentist_id, dentist.dentist_name,\n" +
                "appointments.appointment_day, appointments.appointment_time, appointments.patient from appointments \n" +
                "join dentist on appointments.dentist_id = dentist.dentist_id\n" +
                "join dentistry on dentist.dentistry_id = dentistry.dentistry_id\n" +
                "where appointments.appointment_day > '" + localDate + "' or (appointments.appointment_day = '" +
                localDate + "' and appointments.appointment_time > '" + localTime + "')";
        return jdbcTemplate.query(SQLquery, new FAMapper());
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
