package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.TTMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.TimeTable;

import java.util.List;

public class TimeTableDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;

    @Autowired
    public TimeTableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TimeTable> index() {
        SQLquery = "select timetable.tt_id, dentist.dentist_id, dentist.dentist_name, dentistry.dentistry_id, dentistry.dentistry_name,\n" +
                "                            week.day_name, timetable.admission_time from timetable\\s\n" +
                "                            join dentist on dentist.dentist_id = timetable.dentist_id\\s\n" +
                "                            join dentistry on dentistry.dentistry_id = dentist.dentistry_id\\s\n" +
                "                            join week on week.day_id = timetable.day_id\\s\n" +
                "                            order by dentistry.dentistry_name, dentist.dentist_name, week.day_id";
        return jdbcTemplate.query(SQLquery, new TTMapper());
    }

    public List<Dentist> filtering() {
        return null;
    }

    public Dentist show(int id) {
        return null;
    }

    public void save(Dentist dentist) {

    }

    public void update(int id, Dentist updatedDentist) {

    }

    public void delete(int id) {

    }
}
