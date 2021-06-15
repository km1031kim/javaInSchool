package com.kopo.kopo;

public class Resident {
	int idx;
	String name;
	int age;
	String sex;
	String apartment;
	
	Resident(){
		
	}
	
	Resident(String name, int age, String sex, String apartment){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.apartment = apartment;
	}
	
	Resident(int idx, String name, int age, String sex){
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

}
