/**
@author Melanie Nguyen <a href= "mailto:melanie.nguyen1@ucalgary.ca">melanie.nguyen@ucalgary.ca</a>
@version 2.5
@since 1.0
*/

//package edu.ucalgary.ensf409;


import java.sql.*;

public class UpdateInventory extends DatabaseAccess {
	
	UpdateInventory(String DBURL, String USERNAME, String PASSWORD) {
		super(DBURL, USERNAME, PASSWORD);
	}


	private String[] itemsOrdered;
	
	//Setter
	public void setItemsOrdered(String[] items) {
		this.itemsOrdered=items;
	}
	
	//Getter
	public String[] getItemsOrdered() {
		return this.itemsOrdered;
	}
	

	/*
	 * Deletes all the items in the list
	 */
	public void removeItem(String table) {
		try {
			for(int i=0;i<itemsOrdered.length;i++) {
			   String query= "DELETE FROM "+table+" WHERE ID = ?";
			   PreparedStatement st= getDBConnect().prepareStatement(query);
			   
			   st.setString(1, itemsOrdered[i]);
			
			   int rows=st.executeUpdate();
			   System.out.println("Rows updated: "+rows);
			   
			   st.close();
			}
		   }
		   catch(SQLException e) {
			   System.out.println("Error, unable to delete teacher");
		   }
	}
}

// 	/**
// 	 * Updates database and changes all categories for a selected item to N
// 	 */
// 	public void changeToN(String[] itemsOrdered, String table) {
// 		String[] categories=null;
		
// 		//Gets all the column names 
// 		try {
// 			   Statement st= dbConnect.prepareStatement(table);
// 			   ResultSet rs = st.executeQuery("SELECT * FROM "+table);
			   
// 			   ResultSetMetaData rsmd = rs.getMetaData();
// 			   int columnCount = rsmd.getColumnCount()-4;
// 			   for (int i = 1,j=0; i <= columnCount; i++,j++ ) {
// 				   if(!rsmd.getColumnName(i).equals("ID")&&!rsmd.getColumnName(i).equals("Type")
// 					   &&!rsmd.getColumnName(i).equals("Price")&&!rsmd.getColumnName(i).equals("MaunID")){
// 					  categories[j] = rsmd.getColumnName(i);
// 					}
// 			   }
// 			   st.close();
// 		   }
// 		   catch(SQLException e) {
// 			   System.out.println("Error, unable to get categories");
// 		   }
		
// 		//Updates the table and sets all categories to N for items in the array
// 		 try {
// 			 for(int i=0;i<itemsOrdered.length;i++) {
// 				 int j=0;
// 				 while(j<categories.length) {
// 			   String query= "UPDATE "+table+"SET ?='N' WHERE ID = ?";
// 			   PreparedStatement st= dbConnect.prepareStatement(query);
			   
// 			   st.setString(1, categories[j]);
// 			   st.setString(2, itemsOrdered[i]);
			   
// 			   int rows=st.executeUpdate();
// 			   System.out.println("Rows updated: "+rows);
// 				 } 
// 			 }
			 
// 			 //Should close it but the IDE is being picky about brackets so add it in later
// 			//  st.close();
// 		   } 
// 		   catch(SQLException e) {
// 			   System.out.println("Error, unable to update item status");
// 		   }
// 	}

// }
