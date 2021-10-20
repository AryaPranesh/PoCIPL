package IPL;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.Scanner;

public class Ipl_Insert {
@SuppressWarnings("null")
public static void main(String[] args) throws Exception {
Connection myConn = null;
Statement myStmt = null;
PreparedStatement ps=null;

String dbUrl = "jdbc:mysql://localhost:3306/ipl_teams";
String user = "root";
String pass = "Saviramzmay21!";
try {
myConn = DriverManager.getConnection(dbUrl, user, pass);
myStmt = myConn.createStatement();





/*String sql = "CREATE TABLE IPL_Team " +" (Team_Id VARCHAR(255), " +  " Team_Name VARCHAR(255), " +  " Player_Name VARCHAR(255), " + " Player_Score INTEGER NULL)";
myStmt.executeUpdate(sql);
System.out.println("Created table in given database...");*/


File f = new File("C:\\Users\\arya.ramachandran\\Documents\\POC-DBData\\IPLinput file.txt");
Scanner read = new Scanner(f);

while (read.hasNextLine()) {
    String line = read.nextLine();
   //System.out.println(line);
   
    String[] IPL = line.split("\t");
    String  teamid= IPL[0] ;  
    String teamname= IPL[1]; 
    String playername=IPL[2];
    @SuppressWarnings("resource")
	Scanner s = new Scanner(System.in);
    System.out.println("Enter the score of "+ playername);
    String player_score = s.nextLine();

    
    //System.out.println(teamid+teamname+playername);
    ps.setString(1, teamid);     
    ps.setString(2, teamname);      
    ps.setString(3, playername);
    ps.setString(4, player_score);
    String mql="INSERT INTO IPL_Team (Team_Id, Team_Name,Player_Name,Player_Score) VALUES (?,?,?,?)";
    ps.executeUpdate(mql); 
   
    
   

    
}
read.close();
} catch (Exception e) {
e.printStackTrace();
}
finally {
	
if (myStmt != null) {
myStmt.close();
}

}
if (myConn != null) {
myConn.close();
}
if(ps!=null) {
	ps.close();
}



}



}


