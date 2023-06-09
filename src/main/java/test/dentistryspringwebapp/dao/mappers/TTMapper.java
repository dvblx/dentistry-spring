package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.TimeTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TTMapper implements RowMapper<TimeTable> {
    @Override
    public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TimeTable(rs.getInt("tt_id"), rs.getInt("dentist_id"), rs.getString("dentist_name"),
                rs.getInt("dentistry_id"), rs.getString("dentistry_name"),
                rs.getString("day_name"), rs.getString("admission_time"));
    }
}
