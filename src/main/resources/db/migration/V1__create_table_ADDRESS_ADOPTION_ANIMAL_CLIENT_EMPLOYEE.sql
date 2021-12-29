CREATE TABLE client
(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone_number CHAR(9) UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE address
(
    id SERIAL PRIMARY KEY NOT NULL,
    street_name VARCHAR(255),
    building_number VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255),
    postal_code CHAR(6) NOT NULL,
    city VARCHAR(255) NOT NULL,
    client_id INTEGER NOT NULL
    CONSTRAINT FK_address_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);

CREATE TABLE employee
(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone_number VARCHAR(9) UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    employment_date TIMESTAMP NOT NULL,
    end_date_of_work TIMESTAMP,
    job_position VARCHAR(255) NOT NULL,
    salary FLOAT NOT NULL
);

CREATE TABLE animal
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP,
    adoption_id INTEGER
);

CREATE TABLE adoption
(
    id SERIAL PRIMARY KEY NOT NULL,
    adoption_date TIMESTAMP NOT NULL,
    animal_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL
    CONSTRAINT FK_adoption_animal FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_employee FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);

ALTER TABLE animal
    ADD CONSTRAINT FK_animal_adoption FOREIGN KEY (adoption_id) REFERENCES adoption (id) ON DELETE SET NULL