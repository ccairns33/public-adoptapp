-- DELETE FROM pets;
-- ALTER SEQUENCE pets_id_seq RESTART ;
--
-- DELETE FROM pets_type;
-- ALTER SEQUENCE pets_type_id_seq RESTART;
--
-- DELETE FROM adopters;
-- ALTER SEQUENCE adopters_id_seq RESTART;


INSERT INTO pets (name, pet_type, breed) VALUES
('Princess Kitty',1, 'DSH' ),
('Chance', 2, 'Black Lab');

INSERT INTO adopters (name, phone_number, date_of_adoption, pet_id) VALUES
('Carla Cairns', '8477777111', '2022-06-01', 1);