package lhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lhs.entity.User;
import lhs.oracle.uitl.oracleJDBC;

public class userDao {
	
	public int  updataflagport(int port,int id){
		String sql1=" update chatuser set flag="+port+" where id='"+id+"'";
		 Connection conn;
		 conn=oracleJDBC.getcon();
		 Statement stm=null;
		 try {
			stm=conn.createStatement();
		int i=0;
		i=stm.executeUpdate(sql1);
		if(i!=0){
			return 1;
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		return 0;
	}
public User selectuser(User user){
	Connection conn;
	conn=oracleJDBC.getcon();
	Statement stm = null;
	
	String sql=" select * from chatuser where username='"+user.getUsername()+"' and userpassword='"+user.getUserpassword()+"'";
	try {
		stm=conn.createStatement();
		
		ResultSet rest=null;
		rest=stm.executeQuery(sql);
		while(rest.next()){
		user.setId(rest.getInt(1));
		return user;
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			oracleJDBC.close(conn, stm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
	
	
}	
public int insertuser(User user){
	Connection conn;
	int i=0;
	String sql="insert into chatuser values(1,'"+user.getUsername()+"',"+user.getAge()+",'"+user.getUserpassword()+"',"+user.getFlag()+")";
	conn=oracleJDBC.getcon();
	 Statement stm=null;
	 try {
		stm=conn.createStatement();
		

	i=stm.executeUpdate(sql);
	while(i!=0){
		return i;
		
	}

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally {
		try {
			oracleJDBC.close(conn, stm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
	return i;
}
public static User addfir(int id) {
	 String sql="select * from chatuser where userid="+id+"";
	 Connection conn=oracleJDBC.getcon();
	 try {
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()){
		 User user=new User();
		 user.setUsername(rs.getString("username"));
		 user.setId(rs.getInt(1));
		 return user;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	 
}
public static int addfritrue( int userID,int Friid) {
	 String sql="insert into chatuserFridens values(1,"+userID+","+Friid+")";
	 Connection conn=oracleJDBC.getcon();
	 try {
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()){
		 return 1;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
public static String[] listfir(int id) {
	Connection conn;
	conn=oracleJDBC.getcon();
	Statement stm = null;
	
	String sql="  select * from chatuser cu join  chatuserFridens cf on cu.userid=cf.userid join chatuser cff on cf.userfirid=cff.userid where cu.userid="+id+"";
	try {
		stm=conn.createStatement();
		
		ResultSet rest=null;
		rest=stm.executeQuery(sql);
		while(rest.next()){
		String[] str=new String[1024];
	
		for(int i=0;i<rest.getRow();i++){
			str[i]=rest.getInt(1)+":"+rest.getString("username");
			
		}
	       return str;
		}
			
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			oracleJDBC.close(conn, stm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
	
}
}
