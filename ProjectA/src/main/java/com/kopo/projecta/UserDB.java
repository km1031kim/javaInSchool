package com.kopo.projecta;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class UserDB {
	public boolean createDB() {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());
			// use
			String query = "CREATE TABLE users (idx INTEGER PRIMARY KEY AUTOINCREMENT"
					+ ", id TEXT, pwd TEXT, name TEXT, birthday TEXT, address TEXT, created TEXT, updated TEXT)";
			// sqlite는 정수는 INTEGER, 실수는 REAL, 문자열 TEXT
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();

			// close
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertDB(People people) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());

//			String query = "INSERT INTO users (id, pwd, name, birthday, address, created, updated) VALUES ('"
//					+ people.id + "', '"
//					+ people.pwd + "', '"
//					+ people.name + "', '"
//					+ people.birthday + "', '"
//					+ people.address + "', '"
//					+ people.created + "', '"
//					+ people.updated + "'"
//					+ ")";
//			Statement statement = connection.createStatement();
//			int result = statement.executeUpdate(query);

			// password hash md5, sha .... sha256
			people.pwd = sha256(people.pwd);

			String query = "INSERT INTO users (id, pwd, name, birthday, address, created, updated)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, people.id);
			preparedStatement.setString(2, people.pwd);
			preparedStatement.setString(3, people.name);
			preparedStatement.setString(4, people.birthday);
			preparedStatement.setString(5, people.address);
			preparedStatement.setString(6, people.created);
			preparedStatement.setString(7, people.updated);
			int result = preparedStatement.executeUpdate();

			if (result < 1) {
				return false;
			}
			preparedStatement.close();

			// close
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String sha256(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());

			StringBuilder builder = new StringBuilder();
			for (byte b : md.digest()) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String selectData() {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());

			String query = "SELECT * FROM users";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("birthday");
				String address = resultSet.getString("address");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");

				resultString = resultString + "<tr>";
				resultString = resultString + "<td>" + idx + "</td><td>" + id + "</td><td>" + name + "</td><td>"
						+ birthday + "</td><td>" + address + "</td><td>" + created + "</td><td>" + updated
						+ "</td><td><a href='update?idx=" + idx + "'>수정하기</a></td><td><a href='delete?idx=" + idx
						+ "'>삭제하기</a>";
				resultString = resultString + "</tr>";
			}
			preparedStatement.close();

			// close
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}

	public People detailsData(int idx) {
		People resultData = new People();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db",
					config.toProperties());

			String query = "SELECT * FROM users WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.id = resultSet.getString("id");
				resultData.name = resultSet.getString("name");
				resultData.birthday = resultSet.getString("birthday");
				resultData.address = resultSet.getString("address");
				resultData.created = resultSet.getString("created");

			}
			preparedStatement.close();

			// close
			connection.close();
		} catch (Exception e) {
		}
		return resultData;
	}
	
	public void updateData(int idx, String id, String name , String birthday, String address) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db", config.toProperties());			

			String query = "UPDATE users SET name=?, birthday=?, address=?, updated=datetime('now') WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, birthday);
			preparedStatement.setString(3, address);
			preparedStatement.setInt(4, idx);
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			
			// close
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(int idx) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/user.db", config.toProperties());			

			String query = "DELETE FROM users WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			
			// close
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
