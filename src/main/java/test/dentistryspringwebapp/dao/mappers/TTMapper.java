package test.dentistryspringwebapp.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import test.dentistryspringwebapp.models.TimeTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TTMapper implements RowMapper<TimeTable> {
    @Override
    public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
