package com.kopo.jg;

public class Memo {
	int idx;
	String title;
	String content;
	int userIdx;

	
	Memo(){
		
	}
	
	Memo(int idx, String title, String content, int userIdx){
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.userIdx = userIdx;
	}
}
