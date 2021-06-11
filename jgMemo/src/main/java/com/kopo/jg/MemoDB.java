package com.kopo.jg;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class MemoDB {

	public boolean createTable() {
		boolean isSuccess = false;
		// open
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "C:/tomcat/memo.db",
					config.toProperties());
			// use
			String query = "CREATE TABLE memo(idx INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, created TEXT, updated TEXT, userIdx INTEGER)";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			String query2 = "CREATE TABLE memoUser(idx INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, pwd TEXT, name TEXT, birthday TEXT, address TEXT, joindate TEXT)";
			Statement statement2 = connection.createStatement();
			int result2 = statement2.executeUpdate(query2);

			statement.close();
			statement2.close();
			connection.close();

			// close
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean insertDB(User User) {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());

			// 아이디 중복 여부 검사
			String query1 = "SELECT * FROM memoUser WHERE id=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			preparedStatement1.setString(1, User.id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			if (resultSet.next()) {
				preparedStatement1.close();
				connection.close();
				return false;
			}
			preparedStatement1.close();

			User.pwd = sha256(User.pwd);// password hash sha256 -> 주로사용

			String query = "INSERT INTO memoUser (id, pwd, name, birthday, address, joindate) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, User.id);
			preparedStatement.setString(2, User.pwd);
			preparedStatement.setString(3, User.name);
			preparedStatement.setString(4, User.birthday);
			preparedStatement.setString(5, User.address);
			preparedStatement.setString(6, User.joindate);
			int result = preparedStatement.executeUpdate();

			if (result < 1) {
				preparedStatement.close();
				connection.close();
				return false;
			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static String sha256(String msg) { // 비밀번호 암호화
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

	public static int loginDB(String id, String pwd) { // 로그인
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());

			pwd = sha256(pwd);// password hash sha256 -> 주로사용

			String query = "SELECT * FROM memoUser WHERE id=? AND pwd=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				preparedStatement.close();
				connection.close();
				return idx;
			} else {
				preparedStatement.close();
				connection.close();
				return -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public User selectInfo(int idx) { // 로그인
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());
			User temp = new User();

			String query = "SELECT * FROM memoUser WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				temp.idx = resultSet.getInt("idx");
				temp.id = resultSet.getString("id");
				temp.pwd = resultSet.getString("pwd");
				temp.name = resultSet.getString("name");
				temp.birthday = resultSet.getString("birthday");
				temp.address = resultSet.getString("address");
				preparedStatement.close();
				connection.close();
				return temp;

			} else {
				preparedStatement.close();
				connection.close();

			}

			return temp;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	public boolean insertMemo(String title, String content, String created, String updated, int userIdx) { // 로그인
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());

			String query = "INSERT INTO memo (title, content, created, updated, userIdx) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, created);
			preparedStatement.setString(4, updated);
			preparedStatement.setInt(5, userIdx);
			int result = preparedStatement.executeUpdate();

			if (result < 1) {
				preparedStatement.close();
				connection.close();
				return false;
			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String memoList(int idx) {
		String resultString = "";
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());

			String query = "SELECT * FROM memo WHERE userIdx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int IDX = resultSet.getInt("idx");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>" + "<td>" + idx + "</td>" + "<td>" + title + "</td>" + "<td>"
						+ content + "</td>" + "<td>" + created + "</td>" + "<td>" + updated + "</td>" + "<td><a href='update?idx=" + idx
						+ "'>수정하기</a></td>" + "<td><a href='delete?idx=" + idx + "'>삭제하기</a></td>" + "</tr>";

			} else {
				preparedStatement.close();
				connection.close();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultString;

	}
	
	
	public Memo selectMemo(int userIdx, int Memoidx) {
		String resultString = "";
		Memo temp = new Memo();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\memo.db",
					config.toProperties());

			String query = "SELECT * FROM memo WHERE userIdx=? AND idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userIdx);
			preparedStatement.setInt(2, Memoidx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				temp.title = resultSet.getString("title");
				temp.content = resultSet.getString("content");
				temp.idx = resultSet.getInt("idx");
				temp.userIdx = resultSet.getInt("userIdx");
								
			} else {
				preparedStatement.close();
				connection.close();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return temp;

	}
	
	
}
