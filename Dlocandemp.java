import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.*;

public class Dlocandemp 

{

public static void main(String[] args)   

{
	String s1="null";
	
try 
{	
				System.out.println("Hello-1");

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection dbvar = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "sxp4268", "Apple123"); 
	String inputstr="";			
	BufferedReader tmpvar=new BufferedReader( new FileReader("DEPT_LOCATIONS.txt"));

while( (inputstr=tmpvar.readLine())!=null)
{                
	inputstr=inputstr.replace("'","");
	String[] data=inputstr.split( ", ");
	String cmd="insert into DEPT_LOCATIONS values('"+data[0]+"','"+data[1]+"')";
	PreparedStatement temp_stmt = dbvar.prepareStatement(cmd);
	temp_stmt.executeUpdate(cmd);
	temp_stmt.close();
}

	tmpvar.close();
	dbvar.close();
} 

catch (Exception tableEx) 
{
	tableEx.printStackTrace();
}

try 
{
			System.out.println("Hello0");

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection dbvar = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "sxp4268", "Apple123"); 
	String input_row="";			
	BufferedReader tempvar=new BufferedReader( new FileReader("EMPLOYEE.txt"));

while( (input_row=tempvar.readLine())!=null)
{                
	input_row=input_row.replace("'","");
	String[] data=input_row.split( ", ");
	
	//System.out.println(data[8]);
	if (data[1].equals(s1)) {
		System.out.println("Hello1");
		String cmd="insert into EMPLOYEE values('"+data[0]+"',null,'"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"', '"+data[8]+"','"+data[9]+"')";
		PreparedStatement temp_statement = dbvar.prepareStatement(cmd);	
		temp_statement.executeUpdate(cmd);
		temp_statement.close();
	}
	else if (data[8].equals(s1)) {
		System.out.println("Hello");
		String cmd="insert into EMPLOYEE values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"', null,'"+data[9]+"')";
		PreparedStatement temp_statement = dbvar.prepareStatement(cmd);	
		temp_statement.executeUpdate(cmd);
		temp_statement.close();

		/*String query=" INSERT INTO EMPLOYEE (FNAME, MINIT, LNAME, SSN, BDATE, ADDRESS, SEX, SALARY, SUPERSSN, DNO) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=dbvar.prepareStatement(query);
		stmt.setString(0, data[0]);
		stmt.setString(1, data[1]);
		stmt.setString(2, data[2]);
		stmt.setString(3, data[3]);
		stmt.setString(4, data[4]);
		stmt.setString(5, data[5]);
		stmt.setString(6, data[6]);
		stmt.setString(7, data[7]);
		stmt.setNull(8, java.sql.Types.VARCHAR);
		//stmt.setString(8, null);
		stmt.setString(9, data[9]);
		stmt.executeUpdate();*/
		
	}
  else{
	//System.out.println("Hi");
	String cmd="insert into EMPLOYEE values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"','"+data[8]+"','"+data[9]+"')";
	PreparedStatement temp_statement = dbvar.prepareStatement(cmd);	
	temp_statement.executeUpdate(cmd);
	temp_statement.close();
		}

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