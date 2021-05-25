package com.kopo.jingyu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.jstl.sql.Result;

import org.sqlite.SQLiteConfig;

public class JGDB {
	public void createTable() {
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/jg2.db",
					config.toProperties());

			// use
			String query = "CREATE TABLE student (idx INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, middleScore REAL, finalScore REAL, created TEXT)";
			// SQLITE는 정수 - INTEGER, 실수 - REAL, 문자열 - TEXT
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();

			// close
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertData(String name, double middleScore, double finalScore) {
		try {
			
			//open
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/jg2.db",
					config.toProperties());

			// use
			String query = "INSERT INTO student ( name, middleScore, finalScore, created ) VALUES "
						+ "	('" + name + "', " + middleScore + "," + finalScore + ", datetime('now'))";
			// SQLITE는 정수 - INTEGER, 실수 - REAL, 문자열 - TEXT
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateData(int idx, String name, double middleScore, double finalScore) {
		
	}
	
	public String selectData() {
		String resultString = "";
		try {
			//open
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/jg2.db",
					config.toProperties());
			

			// use
			// DB에서 조회. 실질적으로 조회가 된 데이터 밖에서 존재하는 커서 - > 어디를 가리키고 있는지... next하면 커서가 위에서 아래로
			// 하나씩 이동..
			// 현재 가리키고 있는 위치의 컬럼값을 가져온다.
			// perparedStatement는 ? 처리 가능.
			String query = "SELECT * FROM student";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx"); //안에 컬럼값.
				String name = resultSet.getString("name");
				Double middleScore = resultSet.getDouble("middleScore");
				Double finalScore = resultSet.getDouble("finalScore");
				String created = resultSet.getString("created");
				
				resultString += "<tr>";
				resultString += 
				"<td>" + idx + "</td><td>" + name + "</td><td>" + middleScore + "</td><td>" + finalScore + "</td><td>" + created + "</td><td><a href='update?idx=" + idx + "'>수정하기<a></td>";
						
				resultString += "</tr>";
			}
			
			preparedStatement.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return resultString;
		

	}
	public Student detailsData(int idx) {
		Student resultData = new Student();
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/jg2.db",config.toProperties());
			//use
			String query = "SELECT * FROM student WHERE idx=?";
			PreparedStatement preparedStatements = connection.prepareStatement(query);
			preparedStatements.setInt(1, idx);
			ResultSet resultSet = preparedStatements.executeQuery();
			
			if(resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.name = resultSet.getString("name");
				resultData.middleScore = resultSet.getDouble("middleScore");
				resultData.finalScore = resultSet.getDouble("finalScore");
				resultData.created = resultSet.getString("created");
			}
			preparedStatements.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultData;
	}
	
	public void updateData(int idx, String name, Double middleScore, Double finalScore) {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/jg2.db", config.toProperties());
			
			String query = "UPDATE student SET name=?, middleScore=?, finalScore=?, created=datetime('now') WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, middleScore);
			preparedStatement.setDouble(3, finalScore);
			preparedStatement.setInt(4, idx);
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
