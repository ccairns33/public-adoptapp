package com.expeditors.PetAdoptionAgency.dao.jdbcTemp;

import com.expeditors.PetAdoptionAgency.dao.PetDAO;
import com.expeditors.PetAdoptionAgency.domain.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Profile("jdbct-dev")
@Component
public class JdbcTPetDAO implements PetDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTPetDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static class PetRowMapper implements RowMapper<Pet>{

        @Override
        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Pet.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .type(Pet.PetType.valueOf(rs.getString("pet_type")))
                    .breed(rs.getString("breed"))
                    .adopterId(rs.getInt("adopter_id"))
                    .build();

        }
    }
    @Override
    public Pet insert(Pet newPet) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM pets WHERE id = ?",
                id
        );
        return true;
    }

    @Override
    public boolean update(Pet pet, Integer id) {
    jdbcTemplate.update(
            "UPDATE pets SET id = ?, name = ?, breed = ?, adopter_id = ?, pet_type = ? WHERE id = ?",
                pet.getPetId(), pet.getName(), pet.getBreed(), pet.getAdopterId(), pet.getType().toString(), id
            );
        return true;

    }

    @Override
    public Optional<Pet> findById(int id) {
        List<Pet> results = jdbcTemplate.query("SELECT id, name, pet_type, breed, adopter_id FROM pets WHERE id = ? LIMIT 1",
                new PetRowMapper(),
                id);

        return results.stream().findFirst();
    }

    @Override
    public List<Pet> findAll() {
        return jdbcTemplate.query(("SELECT id, name, pet_type, breed, adopter_id FROM pets"),
                new PetRowMapper());

    }

    @Override
    public void create(Pet pet) {
        jdbcTemplate.update(
                "INSERT INTO pets ( name, pet_type, breed, adopter_id) VALUES (?,?,?,?)",
                pet.getName(),
                pet.getType().toString(),
                pet.getBreed(),
                pet.getAdopterId()
        );


    }

    @Override
    public List<Pet> getAllPets(Integer id) {
        return null;
    }

    @Override
    public Optional<Pet> findByName(String name) {
        List<Pet> results = jdbcTemplate.query("SELECT id, name, breed, adopter_id, pet_type FROM pets WHERE name = ?",
                new PetRowMapper(),
                name);

        return results.stream().findFirst();
    }

    @Override
    public Optional<Pet> findByAdopterId(Integer adopterId) {
        List<Pet> results = jdbcTemplate.query("SELECT id, name, breed, adopter_id, pet_type FROM pets WHERE adopter_id = ?",
                new PetRowMapper(),
                adopterId);

        return results.stream().findFirst();
    }

}
