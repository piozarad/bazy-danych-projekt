package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.DatabaseStructure;

public class InitialConnection {
	public static void connect(DatabaseStructure structure) {

	String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "bananbanan123";
    List<String> temp = new ArrayList<>();

			
			
    

        // Register the PostgreSQL driver

        try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

        // Connect to the database

        //add priorities
		try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			PreparedStatement ps = connection.prepareStatement("SELECT priority_name FROM Priorites"); 
			ResultSet result = ps.executeQuery();
			
			String priority; 
			
			while (result.next()) {
				priority = result.getString("priority_name");
				temp.add(priority);
	            
	        }
			structure.setPriorities(temp);
			temp.clear();
			
			//add statuses
			ps = connection.prepareStatement("SELECT status_name FROM status"); 
			result = ps.executeQuery();
			String status; 
			while (result.next()) {
				status = result.getString("status_name");
				temp.add(status);
				
	            
	        } 
			temp.add("Dowolny");
			structure.setStatuses(temp);
			temp.clear();
			
			
			//add defect types
			ps = connection.prepareStatement("SELECT type_name FROM Defect_types"); 
			result = ps.executeQuery();
			String types; 
			while (result.next()) {
				types = result.getString("type_name");
				temp.add(types);
				
	            
	        }
			temp.add("Dowolny");
			structure.setTypes(temp);
			temp.clear();	
			
			structure.setConnectionState("Pomyslnie polaczono z baza danych " + username);
				
			
		} catch (SQLException e) {
			
			structure.setConnectionState("Blad polaczenia z baza danych");
			e.printStackTrace();
		}
		


	
	}
}
	
	

