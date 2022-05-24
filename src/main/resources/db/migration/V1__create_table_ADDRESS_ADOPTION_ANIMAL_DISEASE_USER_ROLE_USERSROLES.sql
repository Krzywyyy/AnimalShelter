CREATE TABLE app_user
(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone_number VARCHAR(9) UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    employment_date TIMESTAMP,
    end_date_of_work TIMESTAMP,
    job_position VARCHAR(255),
    salary FLOAT,
    user_type VARCHAR(255) NOT NULL
);

CREATE TABLE address
(
    id SERIAL PRIMARY KEY NOT NULL,
    street_name VARCHAR(255),
    building_number VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255),
    postal_code VARCHAR(6) NOT NULL,
    city VARCHAR(255) NOT NULL,
    client_id INTEGER NOT NULL,
    CONSTRAINT FK_address_client FOREIGN KEY (client_id) REFERENCES app_user (id) ON DELETE CASCADE
);

CREATE TABLE animal
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP,
    adoption_id INTEGER
);

CREATE TABLE disease
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    animal_id INTEGER NOT NULL,
    CONSTRAINT FK_disease_animal FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE
);

CREATE TABLE adoption
(
    id SERIAL PRIMARY KEY NOT NULL,
    adoption_date TIMESTAMP NOT NULL,
    animal_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL,
    CONSTRAINT FK_adoption_animal FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_client FOREIGN KEY (client_id) REFERENCES app_user (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_employee FOREIGN KEY (employee_id) REFERENCES app_user (id) ON DELETE CASCADE
);

ALTER TABLE animal
    ADD CONSTRAINT FK_animal_adoption FOREIGN KEY (adoption_id) REFERENCES adoption (id) ON DELETE SET NULL;

CREATE TABLE role
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id) REFERENCES app_user (id) ON DELETE CASCADE,
    CONSTRAINT FK_user_role_role_id FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);

