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
import model.Defect;
import model.Defect.DefectBuilder;
import model.SearchQuery;

public class ConnectionUtils {

	
	
	public static void search(SearchQuery query, DatabaseStructure structure)
	{

		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
	    String username = "postgres";
	    String password = "bananbanan123";
	    
	    
	    try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			PreparedStatement ps = connection.prepareStatement(query.getSearchQuery()); 
			ResultSet result = ps.executeQuery();
		result = ps.executeQuery();
		Defect temp;
		int i=1;
		List <Defect> defects = new ArrayList<>();
		while (result.next()) {
		
			temp = new DefectBuilder(i++)
					.setUseName(result.getString(2))
					.setDistrict(result.getString(3))
					.setType(result.getString(4))
					.setpriority(result.getString(5))
					.setDateAdded(result.getString(6))
					.setDateLastModified(result.getString(7))
					.setComment(result.getString(8))
					.setGpsLocation(result.getString(9))
					.setAdress(result.getString(10))
					.setFeedback(result.getString(11))
					.setStatusId(result.getString(12))
					.build();
		
			
			defects.add(temp);
			
        } 
		structure.setDefects(defects);
	
		
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"B³±d po³±czenia z baz± danych","B³±d SQL", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
}
}
