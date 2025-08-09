---

# Hotel Management System (Java + JDBC + MySQL)

A simple **Hotel Management System** built in Java using **JDBC** to connect with a **MySQL** database (`hotel_db`).
This console-based application allows managing hotel operations such as **room reservations, check-ins, check-outs**, and **customer records**.

---

## 📌 Features

* ✅ Connects to MySQL database using JDBC
* ✅ Add new customer bookings
* ✅ Check-in and check-out rooms
* ✅ View reservation details
* ✅ SQL script included to set up the database

---

## 🛠️ Tech Stack

* **Java** (Core Java, JDBC)
* **MySQL** (Relational Database)
* **SQL** (Queries for data management)
* **JDBC Driver** (MySQL Connector)

---

## 📂 Project Structure

```
hotelmanagementsystemJDBC/
│── src/
│   └── HotelReservationSystem.java   # Main program
│── database.sql                       # SQL script to create and populate hotel_db
│── README.md                          # Project documentation
│── .gitignore                         # Ignore compiled files
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/hotelmanagementsystemJDBC.git
cd hotelmanagementsystemJDBC
```

### 2️⃣ Import Database

1. Open MySQL or phpMyAdmin.
2. Create a new database:

```sql
CREATE DATABASE hotel_db;
```

3. Import `database.sql` into `hotel_db`.

### 3️⃣ Configure JDBC in Code

In `HotelReservationSystem.java`, update:

```java
private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
private static final String username = "root";
private static final String password = "your_mysql_password";
```

### 4️⃣ Compile and Run

```bash
javac src/HotelReservationSystem.java
java -cp .;mysql-connector-j-8.0.33.jar src/HotelReservationSystem
```

---

## 📝 SQL Script Overview (`database.sql`)

The SQL file contains:

* Table creation for **Rooms**, **Customers**, and **Bookings**
* Sample data for quick testing
* Relationships between tables

---

## 🚀 Future Enhancements

* Add **JavaFX GUI** for better user experience
* Include **admin panel** for hotel staff
* Add **payment system** integration

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Naved**
📧 Email: [navedsheikh7983@gmail.com](mailto:your.email@example.com)
🔗 GitHub: [Naved-Sheikh](https://github.com/yourusername)

---

Do you also want me to make the **`database.sql`** file so your GitHub repo works instantly for anyone who downloads it? That will make it look professional.
