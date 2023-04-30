package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.PAMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.PreviousAppointment;

import java.util.List;

public class PreviousAppointmentDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;
    @Autowired
    public PreviousAppointmentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PreviousAppointment> index(){
        SQLquery = "select previousappointments.previous_appointment_id, dentistry.dentistry_id, dentistry.dentistry_name,\n" +
                "                dentist.dentist_id, dentist.dentist_name, previousappointments.appointment_day,\n" +
                "                previousappointments.appointment_time, previousappointments.patient,\n" +
                "                previousappointments.diagnosis, previousappointments.admission_price from previousappointments \n" +
                "                join dentist on previousappointments.dentist_id = dentist.dentist_id \n" +
                "                join dentistry on dentist.dentistry_id = dentistry.dentistry_id\n" +
                "                 where diagnosis != 'нужно указать' or admission_price != 0 ";
        return jdbcTemplate.query(SQLquery, new PAMapper());
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
