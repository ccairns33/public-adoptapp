/*DROP TABLE IF EXISTS "pets";
DROP TABLE IF EXISTS "adopters";
  DROP TABLE IF EXISTS "pets_type";
*/

SET ROLE larku;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT USAGE ON SCHEMA public TO larku;
GRANT SELECT, INSERT, UPDATE, DELETE, TRUNCATE on ALL TABLES IN SCHEMA public TO larku;
GRANT USAGE, SELECT, UPDATE on ALL SEQUENCES IN SCHEMA public TO larku;

-- DROP CASCADE
/*DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS pets_type;
DROP TABLE IF EXISTS adopters;*/


CREATE SEQUENCE pets_id_seq;
CREATE SEQUENCE pets_type_id_seq;
CREATE SEQUENCE adopters_id_seq;

-- CREATE TABLE "pets_type"(
--     id bigint DEFAULT nextval('pets_type_id_seq') NOT NULL,
--     type text NOT NULL,
--     CONSTRAINT "pets_type_pkey" PRIMARY KEY(id)
--
-- );
CREATE TABLE "pets"(
    id bigint DEFAULT nextval('pets_id_seq') NOT NULL,
    name text NOT NULL,
    pet_type text,
    breed text NOT NULL,
    adopter_id bigint,
    CONSTRAINT pets_pkey PRIMARY KEY (id)

);


CREATE TABLE "adopters"(
    id bigint DEFAULT nextval('adopters_id_seq') NOT NULL,
    name text NOT NULL,
    phone_number text NOT NULL,
    date_of_adoption date NOT NULL,
    pet_id bigint,
    CONSTRAINT "adopters_pkey" PRIMARY KEY (id)

);

ALTER TABLE pets
--     ADD CONSTRAINT  "fk_pet_type" FOREIGN KEY (pet_type)
--         REFERENCES pets_type(id),
    ADD CONSTRAINT  "fk_adopter_id" FOREIGN KEY (adopter_id)
        REFERENCES adopters(id);

ALTER TABLE adopters
    ADD CONSTRAINT "fk_pet_id" FOREIGN KEY (pet_id)
        REFERENCES pets(id)

-- create table adopters
-- (
--     id               bigint default nextval('adopters_id_seq'::regclass) not null
--         primary key,
--     name             text                                                not null,
--     phone_number     text                                                not null,
--     date_of_adoption date                                                not null,
--     pet_id           bigint
--         constraint fk_pet_id
--             references pets
-- );
--
-- alter table adopters
--     owner to larku;

--
-- create table pets
-- (
--     id         bigint default nextval('pets_id_seq'::regclass) not null
--         primary key,
--     name       text                                            not null,
--     breed      text                                            not null,
--     adopter_id bigint
--         constraint fk_adopter_id
--             references adopters,
--     pet_type   text
-- );
--
-- alter table pets
--     owner to larku;
--
