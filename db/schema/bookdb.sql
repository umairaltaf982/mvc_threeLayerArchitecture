CREATE DATABASE bookdb;
USE bookdb;
CREATE TABLE books (
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(255) NOT NULL,
author VARCHAR(255),
year INT
);

INSERT INTO books (title, author, year) VALUES
('Laash ka Qehqaha', 'Ibn e Safi', 1954),
('Jiraal ka Mansubah', 'Ishtiaq Ahmad', 1985),
('Ameer Hamza Koh-e-Qaf Mein', 'Maqbool Jahangir', 1951),
('Umro ki Ghaddari', 'Akhtar Rizvi', 1960),
('Chalosak Malosak Sabz Sitaray Mein', 'Mazhar Kaleem', 1980),
('Hajjaam aur Qazzaaq', 'Iqbal Kardar', 1949);
