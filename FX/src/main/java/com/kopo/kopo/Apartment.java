package com.kopo.kopo;

public class Apartment {
	int idx;
	String name;
	int residentIdx;
	
	Apartment(){
		
	}
	
	Apartment(int idx, String name){
		this.idx = idx;
		this.name = name;
	}
	
	Apartment(int idx, String name, int residentIdx){
		this.idx = idx;
		this.name = name;
		this.residentIdx = residentIdx;
	}
	
	Apartment(String name){
		this.name = name;
	}

}
