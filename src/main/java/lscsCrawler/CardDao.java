package lscsCrawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDao {
	String urldb = "jdbc:mysql://localhost:3306/hs?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	public void save(String id, String artist, String attack, String background
			,String cardClass, String cardEffect, String cardRace, String cardRarity,
			String cardSet, String cardType, String code, String consume, String cost
			,String createTime, String description, String durability, String gain, 
			String golden, String health, String imageUrl, String name, String neutralClass, String updateTime) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动不存在");
		}
		Connection connection = DriverManager.getConnection(urldb);
		PreparedStatement ps = connection.prepareStatement("insert into card (id, artist,attack, background,cardClass, cardEffect, cardRace, cardRarity,cardSet, cardType, code, consume, cost,description, durability, gain, golden, health, imageUrl, name) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, artist);
		ps.setString(3, attack);
		ps.setString(4, background);
		ps.setString(5, cardClass);
		ps.setString(6, cardEffect);
		ps.setString(7, cardRace);
		ps.setString(8, cardRarity);
		ps.setString(9, cardSet);
		ps.setString(10, cardType);
		ps.setString(11, code);
		ps.setString(12, consume);
		ps.setString(13, cost);
		ps.setString(14, description);
		ps.setString(15, durability);
		ps.setString(16, gain);
		ps.setString(17, golden);
		ps.setString(18, health);
		ps.setString(19, imageUrl);
		ps.setString(20, name);
		ps.execute();
		ps.close();
		connection.close();
	}
	public List<String> getAllImgUrl() throws SQLException{
		List<String> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动不存在");
		}
		Connection connection = DriverManager.getConnection(urldb);
		PreparedStatement ps = connection.prepareStatement("select name,imageUrl from card");
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()){
			list.add(resultSet.getString(1) + "|" + resultSet.getString(2));
		}
		resultSet.close();
		ps.close();
		connection.close();
		return list;
	}
}
