package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage{
	
	
	
	public void dbConnection(int random) throws SQLException{
	try {
        
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://172.20.26.155;DatabaseName=JAG_QA;user=sa;password=Tpg@1234");
        
        Statement stmt = con.createStatement();
        String query1="SET IDENTITY_INSERT ProgramSession OFF";
        String query = "INSERT [dbo].[ProgramSession] ([SessionName], [SessionGuid], [StartDate], [EndDate], [ProgramId], [IsActive], [CreatedBy], [LastUpdatedBy], [LastUpdatedDate], [SchoolId], [VerifiedBy], [VerifiedDate], [StartedBy], [StartedDate], [District], [JAAreaDistrict], [ClassTime], [PeriodNumber], [Semester], [SessionRequestId], [IsExported], [ExportedDate], [ImplementationModelId], [UnVerifiedBy], [UnVerifiedDate], [TechnologySetUp], [DeliveryModel], [ClassNumber], [BCRMManaged], [IsBCRMExported]) VALUES ('Class_BCRM_KK_"+random+"','52DF48DB-9B8F-5F68-2370-1BC48C58A4DE', CAST(N'2017-03-27T00:00:00.000' AS DateTime), CAST(N'2017-08-01T00:00:00.000' AS DateTime), (select ProgramId from SessionRequest where SessionRequestId = (select max (sessionrequestid) from SessionRequest)), 1, 335, 3, CAST(N'2017-01-12T23:45:50.807' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, (select max (sessionrequestid) from SessionRequest), NULL, NULL, 1, NULL, NULL, 1, 3,(select ClassNumber from SessionRequest where SessionRequestId = (select max (sessionrequestid) from SessionRequest)), 1, 0)";
//        ResultSet rs = stmt.executeQuery("select * from SessionEnrollment where ProgramSessionId='2635';");
        stmt.executeUpdate(query1); 
        stmt.executeUpdate(query);
//        ResultSet rs = stmt.executeQuery("Select top 10 * from Office");
//        while(rs.next()){
//            System.out.println(rs.getInt(1) +" "+ rs.getString(2));
//        }
//        
        con.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
	
	public static void main(String a[]) throws SQLException{
		DatabasePage db = new DatabasePage();
		//db.dbConnection();
		//db.getClassID();
		db.generateRandomNumber();
	}
	
	public String getClassID ()
	{
		String classId="";
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://172.20.26.155;DatabaseName=JAG_QA;user=sa;password=Tpg@1234");
	    Statement stmt = con.createStatement();
        String query="select newId();";
        ResultSet result =  stmt.executeQuery(query);
        while(result.next()){
        	classId = result.getString(1);
        	System.out.println(classId);
        }
        con.close();
		}
		catch(Exception e){
			
		}
	    return classId;
	}
	
	public int generateRandomNumber()
	{
		
		int random = (int)(Math.random()*50) + 1;
		System.out.println(random);
		return random;
		
	}
	
	public void DeleteRecord(String classId)
	{
		try{ 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection con = DriverManager.getConnection("jdbc:sqlserver://172.20.26.155;DatabaseName=JAG_QA;user=sa;password=Tpg@1234");
	        
	        Statement stmt = con.createStatement();
	        String query1 = "delete from [SessionEnrollment] where ProgramSessionId in ( select max (programsessionid) from programsession)";
	        String query2 ="delete from ProgramSession where classnumber ='" +classId+ "'";
	        String query3 ="delete from SessionRequest where classnumber ='" +classId+ "'";
	        
	        int a =stmt.executeUpdate(query1); 
	        int b= stmt.executeUpdate(query2); 
	        int c= stmt.executeUpdate(query3); 
	        System.out.println(a+" "+b+ " "+c+ " ");
		
		con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
	    }
		
	    
		
	}
	
}
