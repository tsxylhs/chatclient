package lhs.oracle.uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class oracleJDBC {
	 static {
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
			 public static Connection getcon(){
				 String url="jdbc:oracle:thin:@127.0.0.1:1521/ORCL";
				 Connection conn = null;
				  try {
					conn=DriverManager.getConnection(url, "lhstsxy", "123321");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 return conn;
				 
			 }
			 public static void close(Connection conn,Statement sts) throws SQLException{
				 if(sts!=null){
					 sts.close();
					 
				 }
				 if(conn!=null){
					 conn.close();
				 }
				 
				 
			 }
}
