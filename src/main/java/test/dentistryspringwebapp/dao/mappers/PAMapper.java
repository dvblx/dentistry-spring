package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.PreviousAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PAMapper implements RowMapper<PreviousAppointment> {
    @Override
    public PreviousAppointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
