package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.Dentistry;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistryMapper implements RowMapper<Dentistry> {
    @Override
    public Dentistry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Dentistry(rs.getInt("dentistry_id"), rs.getString("dentistry_name"),
                rs.getString("address"), rs.getString("phone"), rs.getString("head_of_clinic"),
                rs.getInt("foundation_year"), rs.getInt("customer_count"));
    }
}
