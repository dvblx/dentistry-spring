package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.DentistMapper;
import test.dentistryspringwebapp.dao.mappers.TTMapper;
import test.dentistryspringwebapp.models.Dentist;
import test.dentistryspringwebapp.models.TimeTable;

import java.util.HashMap;
import java.util.List;

public class TimeTableDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;
    HashMap<String, Integer> week = new HashMap<>();

    @Autowired
    public TimeTableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        week.put("Понедельник", 1);
        week.put("Вторник", 2);
        week.put("Среда", 3);
        week.put("Четверг", 4);
        week.put("Пятница", 5);
        week.put("Суббота", 6);
        week.put("Воскресенье", 7);
    }

    public List<TimeTable> index() {
        SQLquery = "select timetable.tt_id, dentist.dentist_id, dentist.dentist_name, dentistry.dentistry_id, dentistry.dentistry_name,\n" +
                "                            week.day_name, timetable.admission_time from timetable\n" +
                "                            join dentist on dentist.dentist_id = timetable.dentist_id\n" +
                "                            join dentistry on dentistry.dentistry_id = dentist.dentistry_id\n" +
                "                            join week on week.day_id = timetable.day_id\n" +
                "                            order by dentistry.dentistry_name, dentist.dentist_name, week.day_id";
        return jdbcTemplate.query(SQLquery, new TTMapper());
    }

    public List<TimeTable> filtering() {
        return null;
    }

    public TimeTable show(int id) {
        return jdbcTemplate.query(SQLquery, new Object[]{id}, new TTMapper())
                .stream().findAny().orElse(null);
    }

    public void save(TimeTable timeTable) {
        SQLquery = "INSERT INTO TIMETABLE(dentist_id, day_id, admission_time) VALUES (?, ?, ?)";
        jdbcTemplate.update(SQLquery, timeTable.getDentist_id(), week.get(timeTable.getDay()), timeTable.getAdmission_time());
    }

    public void update(int id, TimeTable updatedTimeTable) {
        SQLquery = "UPDATE TIMETABLE SET dentist_id, day_id, admission_time WHERE tt_id = ?";
        jdbcTemplate.update(SQLquery, updatedTimeTable.getDentist_id(), week.get(updatedTimeTable.getDay()),
                updatedTimeTable.getAdmission_time(), id);
    }

    public void delete(int id) {
        SQLquery = "DELETE FROM TIMETABLE WHERE tt_id = ?";
        jdbcTemplate.update(SQLquery, id);
    }
}
