import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.*;

public class Deptanddependent 
{

public static void main(String[] args)   
{

try 
{

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection  dbvar = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "sxp4268", "Apple123"); 
	String fileinput="";			
	BufferedReader tempvar=new BufferedReader( new FileReader("DEPARTMENT.txt"));

while( (fileinput=tempvar.readLine())!=null)
{                
	fileinput=fileinput.replace("'","");
	String[] val=fileinput.split( ", ");
	String cmd="insert into DEPARTMENT values('"+val[0]+"','"+val[1]+"','"+val[2]+"','"+val[3]+"')";
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
	String input="";			
	BufferedReader val=new BufferedReader( new FileReader("DEPENDENT.txt"));

while( (input=val.readLine())!=null)
{                
	input=input.replace("'","");
	String[] data=input.split( ", ");
	String cmd="insert into DEPENDENT values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
	PreparedStatement temp_statement = dbvar.prepareStatement(cmd);
	temp_statement.executeUpdate(cmd);
	temp_statement.close();
}

	val.close();
	dbvar.close();
} 
catch (Exception tableEx) 
{
	tableEx.printStackTrace();
}

}

}