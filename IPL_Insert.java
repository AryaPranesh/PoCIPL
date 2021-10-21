package IPL;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class IPL_Insert {
static final String DB_URL = "jdbc:mysql://localhost:3306/ipl_teams";
static final String USER = "root";
static final String PASS = "Saviramzmay21!";

public static void main(String[] args) {
try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
Statement st = con.createStatement();
) {
Statement stm = con.createStatement();
FileInputStream fs = new FileInputStream("C:\\Users\\arya.ramachandran\\Documents\\POC-DBData\\IPLinput file.txt");
DataInputStream ds = new DataInputStream(fs);
BufferedReader br = new BufferedReader(new InputStreamReader(ds));
String s;
ArrayList list = new ArrayList();
while ((s = br.readLine()) != null) {
list.add(s);
}
Iterator itr;
for (itr = list.iterator(); itr.hasNext();) {
String st1 = itr.next().toString();
String[] spliting = st1.split("\t");
String  teamid = "", teamname ="", playername="", playerscore="";
for (int i = 0; i < 11; i++) {

teamid = spliting[0];
teamname = spliting[1];
playername = spliting[2];
}
Scanner Input = new Scanner(System.in);
System.out.println("Enter the score of "+ playername);
playerscore = Input.nextLine();
ResultSet r = null;
Statement stmt1 = con.createStatement();
stmt1.executeUpdate("insert into ipl_team( Team_Id, Team_Name, Player_Name, Player_Score) values('"+teamid+"','"+teamname+"','"+ playername +"', '"+ playerscore +"')");
}
}
catch (SQLException throwables) {
throwables.printStackTrace();
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
}
}
}