package com.kopo.first;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

public class UserDB {

	public void createTable() {

		try {
			// open
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
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
 
			// open
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());

			// use
//			String query = "INSERT INTO student" + "(" + fieldString + ")  VALUES (" + valueString + ")"; // 수정하자.
			String query = "INSERT INTO student" + "( name, middleScore, finalScore, created  )  VALUES ('" + name
					+ "', " + middleScore + "," + finalScore + ", datetime('now'))"; // 쿼리 안 문자열은 "" 묶어야 한다.
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query); // executeUpdate는 결과값이 안나온다.

			// close
			statement.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String selectData() throws SQLException {
		String resultString = "";
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());

			// use
			// DB에서 조회. 실질적으로 조회가 된 데이터 밖에서 존재하는 커서 - > 어디를 가리키고 있는지... next하면 커서가 위에서 아래로
			// 하나씩 이동..
			// 현재 가리키고 있는 위치의 컬럼값을 가져온다.
			// perparedStatement는 ? 처리 가능.
			String query = "SELECT * FROM student"; // SELECT * FROM student WHERE NAME LIKE ?"
			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, 1); // preparedStatement.setString(1, "idx=1") 첫번째 물음표(1)를 idx=1로 바꿔줘 or (1, "%홍%")
			ResultSet resultSet = preparedStatement.executeQuery(); // 결과가 들어오는 resultset. executeQuery는 결과값이 나온다.

			while (resultSet.next()) {
				// next()로 각각 접근
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				double middleScore = resultSet.getDouble("middleScore");
				double finalScore = resultSet.getDouble("finalScore");
				String created = resultSet.getString("created");
				resultString = resultString + "<tr>";
				resultString = resultString + "<td>" + idx + "</td><td>" + name + "</td><td>" + middleScore
						+ "</td><td>" + finalScore + "</td><td>" + created + "</td><td><a href='update?idx=" + idx + "'>수정하기<a></td>";
				resultString = resultString + "</tr>";

			}
			preparedStatement.close();

			// close
			connection.close();
		} catch (Exception e) {

		}
		return resultString;

	}
	
	public Student detailsData(int idx) {
		Student resultData = new Student();
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",config.toProperties());
			
			String query = "SELECT * FROM student WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.name = resultSet.getString("name");
				resultData.middleScore = resultSet.getDouble("middleScore");
				resultData.finalScore = resultSet.getDouble("finalScore");
				resultData.created = resultSet.getString("created");
			}
			preparedStatement.close();
			
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultData;
	}
	
	public void updateData(int idx, String name, double middleScore, double finalScore) {
	try {
		// open
		Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
		SQLiteConfig config = new SQLiteConfig(); // config 생성
		Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",config.toProperties());
		
		String query = "UPDATE student SET name=?, middleScore=?, finalScore=?, created=datetime('now') WHERE idx=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, middleScore);
		preparedStatement.setDouble(3, finalScore);
		preparedStatement.setInt(4, idx);
		int result = preparedStatement.executeUpdate();
		preparedStatement.close();
		
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}	
		
		
	}

}
