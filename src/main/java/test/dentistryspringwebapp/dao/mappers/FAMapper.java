package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.ForthcomingAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FAMapper implements RowMapper<ForthcomingAppointment> {
    @Override
    public ForthcomingAppointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
