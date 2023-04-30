package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.PreviousAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PAMapper implements RowMapper<PreviousAppointment> {
    @Override
    public PreviousAppointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PreviousAppointment(rs.getInt("previous_appointment_id"), rs.getInt("dentistry_id"),
                rs.getString("dentistry_name"), rs.getInt("dentist_id"),
                rs.getString("dentist_name"), rs.getDate("appointment_day").toString(),
                rs.getTime("appointment_time").toString(), rs.getString("patient"),
                rs.getString("diagnosis"), rs.getInt("admission_price"));
    }
}
