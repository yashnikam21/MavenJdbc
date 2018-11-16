package com.model;

public class Register {
private String fname;
private String lname;
private String city;
private String phone;

public String getFname() {
	return fname;
}
@Override
public String toString() {
	return "Register [fname: "+fname+"\nlname]"+lname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
