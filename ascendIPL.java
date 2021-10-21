package IPL;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ascendIPL {


public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	Connection myConn = null;
	Statement myStmt = null;
	String dbUrl = "jdbc:mysql://localhost:3306/ipl_teams";
	String user = "root";
	String pass = "Saviramzmay21!";
	try {
	myConn = DriverManager.getConnection(dbUrl, user, pass);
	myStmt = myConn.createStatement();

    for (int i = 2301; i<2304; i++) {
    String query = "select * from ipl_team where Team_id = '" + i + "' order by Player_Score ASC";
    ResultSet rs = myStmt.executeQuery(query);
    while (rs.next()) {
	String teamid = rs.getString("Team_Id");
	String teamname = rs.getString("Team_Name");
    String playername  = rs.getString("Player_Name");
    String playerscore = rs.getString("Player_Score");
    System.out.println(teamid + "," + teamname + "," + playername + "," + playerscore);
   /* String path = "C:\\\\Users\\\\arya.ramachandran\\\\Documents\\\\POC-DBData\\\\iplascend.txt";

    /*FileWriter writer;
    File file = new File(path);
    writer = new FileWriter(file, true);  
   while((rs!=null) && (rs.next()))
   {
   writer.write(rs.getString("Team_Id"));
   writer.write("\t");
   writer.write(rs.getString("Team_Name"));
   writer.write("\t");
   writer.write(rs.getString("Player_Name"));
   writer.write("\t");
   writer.write(rs.getString("Player_Score"));
   }

   writer.close();*/
}
}
}catch(SQLException e) {
e.printStackTrace();
}finally {
	
if (myStmt != null) {
myStmt.close();
}

}
if (myConn != null) {
myConn.close();
}

}
}