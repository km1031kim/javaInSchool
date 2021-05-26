package com.kopo.prc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class JGDB {
	public void createTable() {
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/aa.db",
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
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/aa.db",
					config.toProperties());

			String query = "INSERT INTO student (name, middleScore, finalScore, created) VALUES ('" + name + "',"
					+ middleScore + "," + finalScore + "," + "datetime('now'))";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
			
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public String selectData() {
		String resultString = "";
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/aa.db",
					config.toProperties());
			
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
		Student temp = new Student();
		
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/aa.db",
					config.toProperties());
			
			
			String queyr = "SELECT * FROM student WHERE idx=?";
			PreparedStatement prepareStatement = connection.prepareStatement(queyr);
			prepareStatement.setInt(1, idx);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if(resultSet.next()) {
				temp.idx = resultSet.getInt("idx");
				temp.name = resultSet.getString("name");
				temp.middleScore = resultSet.getDouble("middleScore");
				temp.finalScore = resultSet.getDouble("finalScore");
				temp.created = resultSet.getString("created");
			}
			prepareStatement.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return temp;
		
	}
	public void updateData(int idx, String name, Double middleScore, Double finalScore) {
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/aa.db",
					config.toProperties());
			
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
