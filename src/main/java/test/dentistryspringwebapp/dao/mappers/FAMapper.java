package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FAMapper implements RowMapper<ForthcomingAppointment> {
    @Override
    public ForthcomingAppointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ForthcomingAppointment(rs.getInt("appointment_id"), rs.getInt("dentistry_id"),
                rs.getString("dentistry_name"), rs.getInt("dentist_id"), rs.getString("dentist_name"),
                rs.getDate("appointment_day").toString(), rs.getTime("appointment_time").toString(),
                rs.getString("patient"));
    }
}
