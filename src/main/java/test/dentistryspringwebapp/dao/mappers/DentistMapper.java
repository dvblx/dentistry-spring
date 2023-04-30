package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.Dentist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistMapper implements RowMapper<Dentist> {
    @Override
    public Dentist mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Dentist(rs.getInt("dentist_id"), rs.getString("dentist_name"),
                rs.getInt("dentistry_id"), rs.getString("dentistry_name"),
                rs.getInt("experience"), rs.getInt("type_id"), rs.getString("type_name"));
    }
}
