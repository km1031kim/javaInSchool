package com.kopo.jingyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class ComDB {
	public void createTable() {

		try {

			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",
					config.toProperties());

			// use
			String query = "CREATE TABLE workers (idx INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, sex TEXT, address TEXT, part TEXT)";

			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query); // 생성은 업데이트.
			statement.close();

			// close
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void insertData(String name, String sex, String address, String part) {

		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",
					config.toProperties());

			String query = "INSERT INTO workers (name, sex, address, part) VALUES" + " ('" + name + "'," + "'" + sex
					+ "'," + "'" + address + "'," + "'" + part + "')";

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
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",
					config.toProperties());

			String query = "SELECT * FROM workers";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery(); // 검색은 익스큐트쿼리

			while (resultSet.next()) {
				int idx = resultSet.getInt("idx"); // 안에 컬럼값.
				String name = resultSet.getString("name");
				String sex = resultSet.getString("sex");
				String address = resultSet.getString("address");
				String part = resultSet.getString("part");

				resultString += "<tr>";
				resultString += "<td>" + idx + "</td><td>" + name + "</td><td>" + sex + "</td><td>" + address
						+ "</td><td>" + part + "</td><td><a href='update?idx=" + idx + "'>수정하기<a></td>" + "<td><a href='delete?idx=" + idx + "'>삭제하기<a></td>";

				resultString += "</tr>";
			}

			preparedStatement.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultString;
	}

	public Worker detailsData(int idx) {

		Worker temp = new Worker();

		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",
					config.toProperties());

			String query = "SELECT * FROM workers WHERE idx=?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, idx);
			ResultSet resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {
				temp.idx = resultSet.getInt("idx");
				temp.name = resultSet.getString("name");
				temp.sex = resultSet.getString("sex");
				temp.address = resultSet.getString("address");
				temp.part = resultSet.getString("part");
			}
			prepareStatement.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return temp;

	}

	public void updateData(int idx, String name, String sex, String address, String part) {
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",config.toProperties());
			
			String query = "UPDATE workers SET name=?, sex=?, address=?, part=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, sex);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, part);
			preparedStatement.setInt(5, idx);
			int result = preparedStatement.executeUpdate(); // 업데이트 쿼리는 업데이터로
			preparedStatement.close();
			
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteData(int idx) {
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",config.toProperties());
			
			
			String query = "DELETE FROM workers WHERE idx=?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, idx);
			int resultSet = prepareStatement.executeUpdate(); // 삭제 ,수정은 익스큐트업데이트
			
			prepareStatement.close();
			
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String searchData(String name) {
		
		String resultString = "";
		try {
			Class.forName("org.sqlite.JDBC"); // sqllite jdbc - db 접속.
			SQLiteConfig config = new SQLiteConfig(); // config 생성
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/Company.db",
					config.toProperties());

			String query = "SELECT * FROM workers WHERE name LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery(); // 검색은 익스큐트쿼리

			while (resultSet.next()) {
				int idx = resultSet.getInt("idx"); // 안에 컬럼값.
				String searchName = resultSet.getString("name");
				String sex = resultSet.getString("sex");
				String address = resultSet.getString("address");
				String part = resultSet.getString("part");

				resultString += "<tr>";
				resultString += "<td>" + idx + "</td><td>" + searchName + "</td><td>" + sex + "</td><td>" + address
						+ "</td><td>" + part + "</td>";

				resultString += "</tr>";
			}

			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultString;
	}
}
