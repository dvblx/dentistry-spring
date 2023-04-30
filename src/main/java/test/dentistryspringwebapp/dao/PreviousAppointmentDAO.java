package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.DentistMapper;
import test.dentistryspringwebapp.dao.mappers.PAMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.PreviousAppointment;

import java.sql.Date;
import java.sql.Time;
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
    public List<PreviousAppointment> filtering(){
        return null;
    }

    public PreviousAppointment show(int id){
        return jdbcTemplate.query(SQLquery, new Object[]{id}, new PAMapper())
                .stream().findAny().orElse(null);
    }
    public void save(PreviousAppointment appointment){
        SQLquery = "INSERT INTO PREVIOUSAPPOINTMENTS(dentist_id, appointment_day, appointment_time, patient, diagnosis," +
                " admission_price) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQLquery, appointment.getDentist_id(), Date.valueOf(appointment.getAppointment_day()),
                Time.valueOf(appointment.getAppointment_time()), appointment.getPatient(), appointment.getDiagnosis(),
                appointment.getAdmission_price());
    }
    public void update(int id, PreviousAppointment updatedAppointment){
        SQLquery = "UPDATE PREVIOUSAPPOINTMENTS SET dentist_id=?, appointment_day=?, appointment_time=?, patient=?," +
                " diagnosis=?, admission_price=? where previous_appointment_id = ?";
        jdbcTemplate.update(SQLquery, updatedAppointment.getDentist_id(), Date.valueOf(updatedAppointment.getAppointment_day()),
                Time.valueOf(updatedAppointment.getAppointment_time()), updatedAppointment.getPatient(),
                updatedAppointment.getDiagnosis(), updatedAppointment.getAdmission_price(), id);

    }
    public void delete(int id) {
        SQLquery = "DELETE FROM PREVIOUSAPPOINTMENTS WHERE previous_appointment_id = ?";
        jdbcTemplate.update(SQLquery, id);
    }
}
