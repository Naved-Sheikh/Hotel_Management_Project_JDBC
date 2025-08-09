-- Create Database
CREATE DATABASE IF NOT EXISTS hotel_db;
USE hotel_db;

-- Table: Customers
CREATE TABLE IF NOT EXISTS Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100)
);

-- Table: Rooms
CREATE TABLE IF NOT EXISTS Rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL,
    room_type VARCHAR(50),
    price_per_night DECIMAL(10,2),
    availability BOOLEAN DEFAULT TRUE
);

-- Table: Bookings
CREATE TABLE IF NOT EXISTS Bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    room_id INT,
    check_in_date DATE,
    check_out_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id) ON DELETE CASCADE
);

-- Insert Sample Rooms
INSERT INTO Rooms (room_number, room_type, price_per_night, availability) VALUES
('101', 'Single', 1500.00, TRUE),
('102', 'Double', 2500.00, TRUE),
('103', 'Suite', 5000.00, TRUE);

-- Insert Sample Customers
INSERT INTO Customers (name, phone, email) VALUES
('Rahul Sharma', '9876543210', 'rahul@example.com'),
('Priya Singh', '8765432109', 'priya@example.com');

-- Insert Sample Bookings
INSERT INTO Bookings (customer_id, room_id, check_in_date, check_out_date) VALUES
(1, 1, '2025-08-10', '2025-08-12'),
(2, 2, '2025-08-15', '2025-08-18');
