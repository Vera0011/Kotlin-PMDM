CREATE DATABASE IF NOT EXISTS App_MySQL_Users;
USE App_MySQL_Users;

CREATE TABLE IF NOT EXISTS Users(
    dni VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    profession VARCHAR(255) NOT NULL,
    salary INTEGER NOT NULL,
    creation_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modification_timestamp TIMESTAMP DEFAULT NULL
);

DROP TRIGGER IF EXISTS add_modification_timestamp;

DELIMITER %%
CREATE TRIGGER add_modification_timestamp BEFORE UPDATE ON Users FOR EACH ROW
BEGIN
    SET New.last_modification_timestamp = CURRENT_TIMESTAMP;
END%%
DELIMITER ;

INSERT INTO Users (dni, name, age, profession, salary)
VALUES ('123456789A', 'John Doe', 30, 'Engineer', 60000),
('987654321B', 'Jane Smith', 25, 'Teacher', 45000),
('555555555C', 'Alice Johnson', 35, 'Doctor', 80000),
('777777777D', 'Bob Williams', 28, 'Software Developer', 70000),
('999999999E', 'Emily Davis', 40, 'Manager', 90000),
('111111111F', 'Michael Brown', 22, 'Student', 20000),
('222222222G', 'Olivia Miller', 33, 'Lawyer', 75000),
('333333333H', 'David Wilson', 45, 'Architect', 85000),
('444444444I', 'Sophia Taylor', 27, 'Marketing Specialist', 60000),
('666666666J', 'Matthew Harris', 32, 'Nurse', 50000);