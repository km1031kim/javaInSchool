package com.kopo.project500;

public class Student {
	int idx;
	String name;
	double middleScore;
	double finalScore;
	String created;
	
	Student() {
		
	}
	
	Student(String name, double middleScore, double finalScore, String created) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.created = created;
	}
	
	Student(int idx, String name, double middleScore, double finalScore, String created) {
		this.idx = idx;
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.created = created;
	}
	
	public String toTableTagString() {
		String htmlString = "<tr>" + "<td>" + this.idx + "</td>"
				 + "<td>" + this.name + "</td>"
				  + "<td>" + this.middleScore + "</td>"
				   + "<td>" + this.finalScore + "</td>"
				    + "<td>" + this.created + "</td>"
				    + "<td>" + "<a href='update?idx=" + this.idx + "'>수정하기</a>" + "</td>"
				    + "</tr>";
		return htmlString;
	}
}
