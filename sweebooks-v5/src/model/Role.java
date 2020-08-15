package model;
import java.util.ArrayList;
import java.util.List;

import main.MySQLAccess;

public class Role {

	private String id;
	private String name;
	
	public Role() {
		
	}
	
	public List<Role> all(){
		return new ArrayList<Role>();
	}

	public Role getByName(String name) {
		
		String getRoleObjectByName = "SELECT id FROM roles " + 
				"WHERE name = '%s'";
		getRoleObjectByName = String.format(getRoleObjectByName, name);
		
		try {
			
			MySQLAccess.rs = MySQLAccess.stmt.executeQuery(getRoleObjectByName);
			
			String id = "";
			
			while(MySQLAccess.rs.next()) {
				
				id = MySQLAccess.rs.getString("id");
				
			}
			
			this.id = id;
			this.name = name;
			
			return this;
			
		} catch (Exception e) {
			
			return null;
			
		}

	}
	
	// Getter and Setter
	
	public String getId() {
		
		return id;
		
	}
}
