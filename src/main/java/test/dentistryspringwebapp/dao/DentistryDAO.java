package test.dentistryspringwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.dentistryspringwebapp.dao.mappers.DentistMapper;
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
        return jdbcTemplate.query(SQLquery, new Object[]{id}, new DentistryMapper())
                .stream().findAny().orElse(null);
    }
    public void save(Dentistry dentistry){
        SQLquery = "INSERT INTO DENTISTRY(dentistry_name, address, phone, head_of_clinic, foundation_year, customer_count)" +
                " VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQLquery, dentistry.getName(), dentistry.getAddress(), dentistry.getPhone(), dentistry.getHead_of_clinic(),
                dentistry.getFoundation_year(), dentistry.getCustomer_count());
    }
    public void update(int id, Dentistry updatedDentistry){
        SQLquery = "UPDATE DENTISTRY SET dentistry_name = ?, address = ?, phone = ?, head_of_clinic = ?, foundation_year = ?," +
                " customer_count = ? where dentistry_id = ?";
        jdbcTemplate.update(SQLquery, updatedDentistry.getName(), updatedDentistry.getAddress(), updatedDentistry.getPhone(),
                updatedDentistry.getHead_of_clinic(), updatedDentistry.getFoundation_year(), updatedDentistry.getCustomer_count(), id);
    }
    public void delete(int id){
        SQLquery = "DELETE FROM DENTISTRY WHERE dentistry_id = ?";
        jdbcTemplate.update(SQLquery, id);
    }
}
