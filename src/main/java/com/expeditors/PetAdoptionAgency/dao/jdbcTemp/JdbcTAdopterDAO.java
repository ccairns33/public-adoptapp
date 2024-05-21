package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.AdopterDAO;
import com.expeditors.PetAdoptionAgency.domain.Adopter;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Profile("jdbct-dev")
@Component
public class JdbcTAdopterDAO implements AdopterDAO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTAdopterDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static class AdopterRowMapper implements RowMapper<Adopter>{
        @Override
        public Adopter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Adopter.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .phoneNumber(rs.getString("phone_number"))
                    .dateOfAdoption((rs.getDate("date_of_adoption")).toLocalDate())
                    .petId(rs.getInt("pet_id"))
                    .build();
        }
    }

    @Override
    public Adopter insert(Adopter newAdopter) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM adopters WHERE id = ?",
                id
        );

        return true;
    }

    @Override
    public boolean update(Adopter adopter, Integer id) {
        jdbcTemplate.update(
                "UPDATE adopters SET id = ?, name = ?, phone_number = ?, date_of_adoption = ?, pet_id = ? WHERE id = ?",
                adopter.getId(), adopter.getName(), adopter.getPhoneNumber(), adopter.getdateOfAdoption(), adopter.getPetId(), id
        );
        return true;
    }

    @Override
    public Optional<Adopter> findById(int id) {
        List<Adopter> results = jdbcTemplate.query("SELECT id, name, phone_number, date_of_adoption, pet_id FROM adopters WHERE id = ? LIMIT 1;",
                new AdopterRowMapper(), id);
        return results.stream().findFirst();
    }

    @Override
    public List<Adopter> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name, phone_number, date_of_adoption, pet_id FROM adopters",
                new AdopterRowMapper()
        );
    }

    @Override
    public void create(Adopter adopter) {
        jdbcTemplate.update("INSERT INTO adopters ( name, phone_number, date_of_adoption, pet_id) VALUES (?, ?,?,?);",
                adopter.getName(), adopter.getPhoneNumber(), adopter.getdateOfAdoption(), adopter.getPetId()
        );

    }

    @Override
    public List<Pet> getAllAdopterPets(Integer id) {
        return null;
    }
}
