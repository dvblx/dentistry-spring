package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.models.Dentist;

import java.util.List;

public class DentistDAO {
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;

    @Autowired
    public DentistDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dentist> index() {
        SQLquery = "select dentist.dentist_id, dentist.dentist_name, dentistry.dentistry_id, dentistry.dentistry_name,\n" +
                "dentist.experience, dentist_type.type_id ,dentist_type.type_name from dentist\n" +
                "join dentistry on dentistry.dentistry_id = dentist.dentistry_id\n" +
                "join dentist_type on dentist_type.type_id = dentist.dentist_type_id";
        return jdbcTemplate.query(SQLquery, new BeanPropertyRowMapper<>(Dentist.class));
    }

    public List<Dentist> filtering() {
        SQLquery = "";
        return jdbcTemplate.query(SQLquery, new BeanPropertyRowMapper<>(Dentist.class));
    }

    public Dentist show(int id) {
        SQLquery = "select dentist.dentist_id, dentist.dentist_name, dentistry.dentistry_id, dentistry.dentistry_name,\n" +
                "dentist.experience, dentist_type.type_id ,dentist_type.type_name from dentist\n" +
                "join dentistry on dentistry.dentistry_id = dentist.dentistry_id\n" +
                "join dentist_type on dentist_type.type_id = dentist.dentist_type_id" +
                "where dentist.dentist_id=?";
        return jdbcTemplate.query(SQLquery, new Object[]{id}, new BeanPropertyRowMapper<>(Dentist.class))
                .stream().findAny().orElse(null);
    }

    public void save(Dentist dentist) {
        SQLquery = "INSERT INTO dentist(dentist_name, dentistry_id, experience, dentist_type_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(SQLquery, dentist.getDentist_name(), dentist.getDentistry_id(), dentist.getExperience(),
                dentist.getDentist_type_id());

    }

    public void update(int id, Dentist updatedDentist) {
        SQLquery = "UPDATE DENTIST SET dentist_name = ?, dentistry_id = ? , experience = ?, dentist_type_id = ? " +
                "WHERE dentist_id = ?";
        jdbcTemplate.update(SQLquery, updatedDentist.getDentist_name(), updatedDentist.getDentistry_id(),
                updatedDentist.getExperience(), updatedDentist.getDentist_type_id(), id);

    }

    public void delete(int id) {
        SQLquery = "DELETE FROM DENTIST WHERE dentist_id = ?";
        jdbcTemplate.update(SQLquery, id);
    }
}
