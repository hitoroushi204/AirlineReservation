CREATE DATABASE IF NOT EXISTS flight_booking;
USE flight_booking;

DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('user', 'admin') DEFAULT 'user'
);

CREATE TABLE flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_no VARCHAR(20) NOT NULL,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departure_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    economy_seats INT NOT NULL,
    business_seats INT NOT NULL,
    economy_price DECIMAL(10,2) NOT NULL,
    business_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    flight_id INT NOT NULL,
    class_type ENUM('Economy', 'Business') NOT NULL,
    num_seats INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_status BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (flight_id) REFERENCES flights(id) ON DELETE CASCADE
);

INSERT INTO users (username, password, role) VALUES 
('admin', '1234', 'admin'),
('john', '123', 'user'),
('jane', '123', 'user');

INSERT INTO flights (flight_no, origin, destination, departure_date, departure_time, economy_seats, business_seats, economy_price, business_price) VALUES
('PR 123', 'Manila', 'Cebu', '2024-12-25', '10:00:00', 150, 50, 150.00, 300.00),
('PR 456', 'Manila', 'Davao', '2024-12-25', '14:00:00', 120, 40, 200.00, 400.00),
('PR 789', 'Cebu', 'Manila', '2024-12-26', '08:00:00', 100, 35, 150.00, 300.00),
('PR 101', 'Davao', 'Manila', '2024-12-26', '16:00:00', 90, 30, 200.00, 400.00),
('PR 202', 'Manila', 'Singapore', '2024-12-27', '09:00:00', 200, 60, 350.00, 700.00),
('PR 303', 'Cebu', 'Davao', '2024-12-27', '13:00:00', 80, 25, 180.00, 360.00),
('PR 404', 'Manila', 'Tokyo', '2024-12-28', '20:00:00', 250, 80, 500.00, 1000.00),
('PR 505', 'Cebu', 'Singapore', '2024-12-28', '22:00:00', 150, 45, 400.00, 800.00);

INSERT INTO bookings (user_id, flight_id, class_type, num_seats, total_price, payment_status) VALUES
(2, 1, 'Economy', 2, 300.00, TRUE),
(2, 2, 'Business', 1, 400.00, TRUE),
(3, 3, 'Economy', 3, 450.00, TRUE);