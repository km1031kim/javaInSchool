package com.kopo.score;

public class Student {
	int idx;  // 고유값
	String name;
	int midScore;
	int finScore;
	String created;
	
	
	
	Student(){
		
	}
	
	Student(String name, int midScore, int finScore, String created){
		this.name = name;
		this.midScore = midScore;
		this.finScore = finScore;
		this.created = created;
		
	}
	
	
	Student(int idx, String name, int midScore, int finScore, String created){
		this.idx = idx;
		this.name = name;
		this.midScore = midScore;
		this.finScore = finScore;
		this.created = created;
		
	}

}


