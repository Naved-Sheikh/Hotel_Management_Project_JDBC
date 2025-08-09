
import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {


    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "admin@123";
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            while(true){
                System.out.println("HOTEL MANAGEMENT SYSTEN");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter 1 For Reserving a Room");
                System.out.println("Enter 2 To View Reservation");
                System.out.println("Enter 3 To Get Room Number");
                System.out.println("Enter 4 For Updating Reservation");
                System.out.println("Enter 5 For Deleting Reservation");
                System.out.println("Enter 0 To Exit");
                System.out.println("Choose an option : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> reservation(connection, sc);
                    case 2 -> ViewReservation(connection);
                    case 3 -> getRoomNumber(connection,sc);
                    case 4 ->updateReservation(connection,sc);
                    case 5 -> deleteReservation(connection,sc);
                    case 0 -> {
                        exit();
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void reservation(Connection connection, Scanner scanner){
        try
        {
            scanner.nextLine();
            System.out.println("Enter Guest Name :");
            String guestName = scanner.nextLine();
            System.out.println("Enter Room Number :");
            String roomNo = scanner.nextLine();
            System.out.println("Enter Contact Number :");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations(guest_name,room_number,contact_number)"+
                    "values ('"+guestName +"'," +roomNo+", '"+contactNumber+"')";

        try(Statement statement = connection.createStatement()){
            int affectedRows = statement.executeUpdate(sql);
            if (affectedRows>0){
                System.out.println("Reservation Sucessfull !!");
            }
            else {
                System.out.println("Reservation Failed");
            }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   private static void deleteReservation(Connection connection, Scanner scanner){
        try{
            System.out.println("Enter reservation ID to delete: ");
            int reservationID = scanner.nextInt();

            if (!reservationExists(connection,reservationID)){
                System.out.println("Reservation not found with given ID ");
                return;
            }

            String sql = "DELETE FROM reservations WHERE reservation_id ="+reservationID;

            try (Statement statement = connection.createStatement()){
                int affectedRows =statement.executeUpdate(sql);

                if (affectedRows>0){
                    System.out.println("Reservation sucessfully deleted!!");
                }
                else {
                    System.out.println(" Reservation Deletion Failed!!");
                }

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
   }

public static void ViewReservation(Connection connection) throws SQLException {
    String sql = "SELECT reservation_id, guest_name , room_number,contact_number,reservation_date FROM reservations";
    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {
        System.out.println("Current Reservations: ");
        System.out.println("-".repeat(20));

        while (resultSet.next()) {
            int reservationId = resultSet.getInt("reservation_id");
            String guestName = resultSet.getString("guest_name");
            String contactNumber = resultSet.getString("contact_number");
            int roomNumber = resultSet.getInt("room_number");
            String reservationDate = resultSet.getString("reservation_date");

            System.out.println("Reservation Id : " + reservationId);
            System.out.println("Guest Name : " + guestName);
            System.out.println("Contact Number :  " + contactNumber);
            System.out.println("ROom NUmber : " + roomNumber);
            System.out.println("Reservation Date :" + reservationDate);
        }
        System.out.println("-".repeat(20));
    }
}


    public static void getRoomNumber(Connection connection, Scanner scanner) {
    try {
        System.out.println("Enter reservation Id :");
        int ReservationId = scanner.nextInt();
        System.out.println("Enter Guest Name: ");
        scanner.nextLine();
        String GuestName = scanner.nextLine();

        String sql = " SELECT room_number FROM reservations " +
                " WHERE reservation_id = " + ReservationId + " AND guest_name = '" + GuestName+"'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int roomNumber = resultSet.getInt("room_number");
                System.out.println("Room Number For Reservation ID " + ReservationId
                        + "AND Guest " + GuestName + " IS " + roomNumber);
            }
                else{
                    System.out.println("Reservatom not founf wiht given ID and guest name!!");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateReservation(Connection connection, Scanner scanner){
        try{
            System.out.println("Enter Reservation ID to Update: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            if (!reservationExists(connection,reservationId)){
                System.out.println("Reservation not found for the given ID.");
                return;
            }

            System.out.println("Enter new guest name: ");
            String newGuestName = scanner.nextLine();
            System.out.println("Enter new room number : ");
            int newRoomNO = scanner.nextInt();
            System.out.println("Enter new Contact Number: ");
            String newContactNumber = scanner.nextLine();

            String sql = "UPDATE reservations SET guest_name = '" + newGuestName +
                    "', room_number = " + newRoomNO +
                    ", contact_number = '" + newContactNumber +
                    "' WHERE reservation_id = " + reservationId;

            try(Statement statement=connection.createStatement()) {
                int affectedRows = statement.executeUpdate(sql);
                if (affectedRows>0){
                    System.out.println("Reservation Sucessfully Updated!!");
                                    }
                else {
                    System.out.println("Reservation Updation Failed!!");
                }
            }} catch (Exception e) {
                System.out.println(e.getMessage());

        }
          }

    private static boolean reservationExists(Connection connection, int reservationId){
        try{
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id ="+reservationId;

            try(Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)){
                return resultSet.next();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void exit() throws InterruptedException{
        System.out.println("Existing System");
        int i =5;
        while(i!=0){
            System.out.print(".");
            Thread.sleep(300);
            i--;
        }
        System.out.println();
        System.out.println("Thank you for using Hotel Reservation System!!!");
    }
}

