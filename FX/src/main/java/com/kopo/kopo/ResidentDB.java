package com.kopo.kopo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sqlite.SQLiteConfig;

public class ResidentDB {

	public boolean createDB() { // 테이블 생성
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/resident.db",
					config.toProperties());
			// use
			String query = "CREATE TABLE resident (idx INTEGER PRIMARY KEY AUTOINCREMENT"
					+ ", name TEXT, age REAL, sex TEXT, apart TEXT)";
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

	public boolean insertResident(Resident Resident) { // 회원정보 삽입
		try {

			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/resident.db",
					config.toProperties());

			String query = "INSERT INTO resident (name, age, sex, apart) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, Resident.name);
			preparedStatement.setInt(2, Resident.age);
			preparedStatement.setString(3, Resident.sex);
			preparedStatement.setString(4, Resident.apartment);

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

	public String selectResident() { // 회원정보 전체조회
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT * FROM resident";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String sex = resultSet.getString("sex");
				String apartment = resultSet.getString("apart");

				resultString = resultString + "<tr>" + "<td>" + idx + "</td>" + "<td>" + name + "</td>" + "<td>" + age
						+ "</td>" + "<td>" + sex + "</td>" + "<td>" + apartment + "</td>" + "<td><a href='update?idx=" + idx + "'>수정하기</a></td>"
						+ "<td><a href='delete?idx=" + idx + "'>삭제하기</a></td>" + "</tr>";

			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

	public Resident searchDetails(int residentIdx) {
		Resident resident = new Resident();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT * FROM resident WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, residentIdx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resident.idx = residentIdx;
				resident.name = resultSet.getString("name");
				resident.age = resultSet.getInt("age");
				resident.sex = resultSet.getString("sex");
				resident.apartment = resultSet.getString("apart");

			} else {
				preparedStatement.close();
				connection.close();

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resident;

	}

	public Boolean updateResident(int idx, String name, int age, String sex) {

		Resident temp = new Resident();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "UPDATE resident SET name=?, age=?, sex=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, sex);			
			preparedStatement.setInt(4, idx);

			int resultSet = preparedStatement.executeUpdate();
			if (resultSet < 1) {

				preparedStatement.close();
				connection.close();
				return false;

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return true;

	}

	public Boolean deleteResident(int idx) {

		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "DELETE FROM resident WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);

			int resultSet = preparedStatement.executeUpdate();
			if (resultSet < 1) {

				preparedStatement.close();
				connection.close();
				return false;

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return true;

	}

	public String residentAvg() {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT COUNT(idx) as num FROM resident";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt("num");

			}

			statement.close();

			String query2 = "SELECT round(avg(age)) as avgAge FROM resident";
			Statement statement2 = connection.createStatement();
			ResultSet resultSet2 = statement2.executeQuery(query2);

			int avgAge = 0;
			while (resultSet2.next()) {
				avgAge = resultSet2.getInt("avgAge");

			}
			statement2.close();

			String query3 = "SELECT COUNT(idx) as womanCnt FROM resident WHERE sex='여'";
			Statement statement3 = connection.createStatement();
			ResultSet resultSet3 = statement3.executeQuery(query3);


			int womanCount = 0;
			while (resultSet3.next()) {
				womanCount = resultSet3.getInt("womanCnt");

			}
			statement3.close();

			String query4 = "SELECT COUNT(idx) as manCnt FROM resident WHERE sex='남'";
			Statement statement4 = connection.createStatement();
			ResultSet resultSet4 = statement4.executeQuery(query4);

			int manCnt = 0;
			while (resultSet4.next()) {
				manCnt = resultSet4.getInt("manCnt");

			}
			statement4.close();


			resultString = resultString 
					+ "<tr>" 
					+ "<td>" + count + "</td>" 
					+ "<td>" + avgAge + "</td>" 
					+ "<td>" + manCnt + " / " + womanCount + "</td>" 
					+ "</tr>";

			
			
			
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;

	}
	
	public boolean createApartTable() { // 테이블 생성
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/resident.db",
					config.toProperties());
			// use
			String query = "CREATE TABLE apartment (idx INTEGER PRIMARY KEY AUTOINCREMENT"
					+ ", name TEXT)";
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
	
	public boolean insertApart(Apartment apart) { // 회원정보 삽입
		try {
			
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/resident.db",
					config.toProperties());

			String query = "INSERT INTO apartment (name) VALUES (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, apart.name);
	

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
	
	public String selectApartment() { // 아파트 정보 전체조회
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT * FROM apartment";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				

				resultString = resultString + "<tr>" + "<td>" + idx + "</td>" + "<td>" + name + "</td>" +  "<td><a href='updateApart?idx=" + idx + "'>수정하기</a></td>"
						+ "<td><a href='deleteApart?idx=" + idx + "'>삭제하기</a></td>" + "</tr>";

			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	public Apartment searhApart(int apartIdx) {
		Apartment apartment = new Apartment();
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT * FROM apartment WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, apartIdx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				apartment.idx = apartIdx;
				apartment.name = resultSet.getString("name");				

			} else {
				preparedStatement.close();
				connection.close();

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return apartment;

	}
	
	public Boolean updateApartmentInfo(int idx, String name) {

		
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "UPDATE apartment SET name=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, idx);


			int resultSet = preparedStatement.executeUpdate();
			if (resultSet < 1) {

				preparedStatement.close();
				connection.close();
				return false;

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return true;

	}
	
	public Boolean deleteApartment(int idx) {

		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "DELETE FROM apartment WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);

			int resultSet = preparedStatement.executeUpdate();
			if (resultSet < 1) {

				preparedStatement.close();
				connection.close();
				return false;

			}
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return true;

	}
	
	public String apartNameList() { // 회원정보 전체조회
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT DISTINCT name FROM apartment";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
		
				String name = resultSet.getString("name");
				

				resultString += name + " / "; 

			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	

	public String apartInfoPrint() { // 
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:\\tomcat\\resident.db",
					config.toProperties());

			String query = "SELECT C.APART, COUNT(C.NAME) FROM (SELECT A.*,B.* FROM resident A LEFT JOIN apartment B ON A.APART=B.NAME)C GROUP BY C.APART";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				String name = resultSet.getString("apart");
				int count = resultSet.getInt("COUNT(C.NAME)");
				

				resultString = resultString + "<tr>" + "<td>" + name + "</td>" + "<td>" + count + "</td>" + "</tr>";

			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

}