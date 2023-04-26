package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.Dentistry;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistryMapper implements RowMapper<Dentistry> {
    @Override
    public Dentistry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
