package com.kopo.jg;

public class User {
	int idx;
	String id;
	String pwd;
	String name;
	String birthday;
	String address;
	String joindate;
	
	User() {
		
	}
	
	User(String newId, String newPwd, String name, String birthday, String address, String joindate) {
		this.id = newId;
		this.pwd = newPwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.joindate = joindate;
	}
	
	User(String userId, String userPwd) {
		this.id = userId;
		this.pwd = userPwd;
	}
}
