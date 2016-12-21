import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static boolean validate(String name,String pass) {
		// TODO Auto-generated method stub
boolean status=false;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
String conString="jdbc:oracle:thin:@localhost:1521:xe";
Connection con=DriverManager.getConnection(conString,"SYSTEM","system");
PreparedStatement ps=con.prepareStatement("select * from DB2.customer where name=? and pass=?") ;
ps.setString(1,name);
ps.setString(2,pass);
ResultSet rs=ps.executeQuery();

status=rs.next();
	}

catch(Exception ex){

	System.out.println(ex);																						
}
return status;
	}
	
}
