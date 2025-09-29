CREATE DATABASE IF NOT EXISTS proiect_masini;

USE proiect_masini;

CREATE TABLE masini (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nr_inmatriculare VARCHAR(20) NOT NULL UNIQUE,
                        marca VARCHAR(50) NOT NULL,
                        an_fabricatie INT NOT NULL,
                        culoare VARCHAR(30),
                        kilometri INT NOT NULL
);

INSERT INTO masini (nr_inmatriculare, marca, an_fabricatie, culoare, kilometri) VALUES
                                                                                    ('B-101-ABC', 'Dacia', 2020, 'Alb', 50000),
                                                                                    ('B-102-DEF', 'Renault', 2018, 'Negru', 80000),
                                                                                    ('CJ-03-XYZ', 'BMW', 2021, 'Albastru', 30000),
                                                                                    ('TM-45-GHI', 'Toyota', 2016, 'Roșu', 150000),
                                                                                    ('AR-67-KLM', 'Ford', 2022, 'Gri', 10000);
