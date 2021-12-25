CREATE TABLE client
(
    id SERIAL NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone_number VARCHAR(9),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE address
(
    id SERIAL NOT NULL,
    street_name VARCHAR(255),
    building_number VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255),
    postal_code VARCHAR(6) NOT NULL,
    city VARCHAR(255) NOT NULL,
    client_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_address_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);

CREATE TABLE employee
(
    id SERIAL NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    phone_number VARCHAR(9),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    employment_date TIMESTAMP NOT NULL,
    end_date_of_work TIMESTAMP,
    salary FLOAT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE animal
(
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    adoption_id INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE adoption
(
    id SERIAL NOT NULL,
    adoption_date TIMESTAMP NOT NULL,
    animal_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_adoption_animal FOREIGN KEY (animal_id) REFERENCES animal (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
    CONSTRAINT FK_adoption_employee FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);

ALTER TABLE animal
    ADD CONSTRAINT FK_animal_adoption FOREIGN KEY (adoption_id) REFERENCES adoption (id) ON DELETE SET NULL