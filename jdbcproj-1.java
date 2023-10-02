import java.sql.*;
import java.util.Scanner;
//Abhilash Ari final proj
public class jdbcproj{
	
		private static String connUrl = "jdbc:postgresql://localhost:63333/ari00001";
		private static Connection conn;
		public static Connection getDBConnection() throws SQLException{
			if(conn == null) {
				conn = DriverManager.getConnection(connUrl,"ari00001","dv9ixusc");
			}
			return conn;
			//creating a connection instance
		}
		public static void display() {
			System.out.println("Select queries 1 or 2");
			System.out.println("Query 1: get id of customer and product");
			System.out.println("Query 2: get associate id");
			//display menu for the user to enter which query 
		}
		public static int getUserInput() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose Query 1 or 2");
			return scanner.nextInt();
		}
		//simple user input scanner
		public static void query1(Connection conn) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter customer id");
				String customerid = scanner.next();
				System.out.println("now enter the product id/barcode");
				String prodid = scanner.next();
				String query = "SELECT* FROM Customer NATURAL JOIN PURCHASES WHERE customer_id =?";
				PreparedStatement qr = conn.prepareStatement(query);
				qr.setString(1, customerid);
				//reading user input and preparing query statement
				ResultSet rs = qr.executeQuery();
				while(rs.next()) {
				System.out.println("Customer id: " + rs.getString("customer_id"));
				System.out.println("Customer name: " + rs.getString("name"));
				System.out.println("Barcodes: " + rs.getString("barcode"));
				}//referenced documentation and sample code in stack overflow
				rs.close();
				qr.close();
				//closing them
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}//exception catching
		public static void query2(Connection conn) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter associate id");
				String associateid = scanner.next();
				String query = "SELECT* FROM Purchases WHERE associate_id =?";
				PreparedStatement qr = conn.prepareStatement(query);
				qr.setString(1, associateid);
				//reading user input and preparing query statement
				ResultSet rs = qr.executeQuery();
				while(rs.next()) {
				System.out.println("Associate id: " + rs.getString("associate_id"));
				System.out.println("Barcode: " + rs.getString("barcode"));
				}//referenced documentation and sample code in stack overflow
				rs.close();
				qr.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		//test driving the code in main, functioned as needed
		public static void main(String[] args) {
			try {
				Connection conn = getDBConnection();
				display();
				int userinput = getUserInput();
				if(userinput == 1) {
					query1(conn);
				}
				if(userinput == 2) {
					query2(conn);
				}
			
				conn.close();
				
			}
	//exception catching
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
