package lhs.entity;

public class User {

	private int id ;
 private String username;
 private int age;
 private  String userpassword;
 private int flag;
 private int port;
 
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", age=" + age + ", userpassword=" + userpassword + ", flag="
			+ flag + ", port=" + port + "]";
}
 
}
