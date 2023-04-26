package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.Dentist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistMapper implements RowMapper<Dentist> {
    @Override
    public Dentist mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
