package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.DentistryMapper;
import test.dentistryspringwebapp.models.Dentistry;

import java.util.List;

public class DentistryDAO{
    private final JdbcTemplate jdbcTemplate;
    private String SQLquery;
    @Autowired
    public DentistryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dentistry> index(){
        SQLquery = "select * from dentistry";
        return jdbcTemplate.query(SQLquery, new DentistryMapper());
    }
    public List<Dentistry> filtering(){
        return null;
    }

    public Dentistry show(int id){
        return null;
    }
    public void save(Dentistry dentist){

    }
    public void update(int id, Dentistry updatedDentistry){

    }
    public void delete(int id){

    }
}
