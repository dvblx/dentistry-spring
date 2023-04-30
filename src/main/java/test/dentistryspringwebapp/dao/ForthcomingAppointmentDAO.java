package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.DentistMapper;
import test.dentistryspringwebapp.dao.mappers.FAMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import java.sql.Date;
import java.sql.Time;
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
    public List<ForthcomingAppointment> filtering(){
        return null;
    }

    public ForthcomingAppointment show(int id){
        return jdbcTemplate.query(SQLquery, new Object[]{id}, new FAMapper())
                .stream().findAny().orElse(null);
    }
    public void save(ForthcomingAppointment appointment){
        SQLquery = "INSERT INTO APPOINTMENTS(dentist_id, appointment_day, appointment_time, patient) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(SQLquery, appointment.getDentist_id(), Date.valueOf(appointment.getAppointment_day()),
                Time.valueOf(appointment.getAppointment_time()), appointment.getPatient());

    }
    public void update(int id, ForthcomingAppointment updatedAppointment){
        SQLquery = "UPDATE APPOINTMENTS SET dentist_id=?, appointment_day=?, appointment_time=?, patient=?" +
                "where appointment_id=?";
        jdbcTemplate.update(SQLquery, updatedAppointment.getDentist_id(), Date.valueOf(updatedAppointment.getAppointment_day()),
                Time.valueOf(updatedAppointment.getAppointment_time()), updatedAppointment.getPatient(),id);
    }
    public void delete(int id){
        SQLquery = "DELETE FROM APPOINTMENTS WHERE APPOINTMENT_ID = ?";
        jdbcTemplate.update(SQLquery, id);
    }
}
