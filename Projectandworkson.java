import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.*;

public class Projectandworkson 

{
public static void main(String[] args)   

{
	
try 
{

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection dbvar = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "sxp4268", "Apple123"); 
	String input_line="";			
	BufferedReader tempvar=new BufferedReader( new FileReader("PROJECT.txt"));

while( (input_line=tempvar.readLine())!=null)
{                
	input_line=input_line.replace("'","");
	String[] data=input_line.split( ", ");
	String cmd="insert into PROJECT values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"')";
	PreparedStatement temp_statement = dbvar.prepareStatement(cmd);
	temp_statement.executeUpdate(cmd);
	temp_statement.close();
}

	tempvar.close();
	dbvar.close();
}

catch (Exception tableEx) 
{
	tableEx.printStackTrace();
}

try 
{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection dbvar = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "sxp4268", "Apple123"); 
	String input_line="";			
	BufferedReader tempvar=new BufferedReader( new FileReader("WORKS_ON.txt"));

while( (input_line=tempvar.readLine())!=null)
{                
	input_line=input_line.replace("'","");
	String[] data=input_line.split( ", ");
	String command="insert into WORKS_ON values('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	PreparedStatement temp_statement = dbvar.prepareStatement(command);
	temp_statement.executeUpdate(command);
	temp_statement.close();
}

	tempvar.close();
	dbvar.close();
} 

catch (Exception tableEx) 
{
	tableEx.printStackTrace();
}

}

}