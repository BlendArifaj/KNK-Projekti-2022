package repository;

import java.sql.ResultSet;

import database.DBConnect;
import database.FilterQueryBuilder;
import database.InsertQueryBuilder;
import model.Login;
import model.User;
import model.DTO.CreateUserDTO;

public class LoginRepository {
	private final String TABLE_NAME = "user";
	private DBConnect connection;
	
	public LoginRepository() {
		this.connection = DBConnect.getInstance();
	}
	
	public Login findOne(String username) {
		try {
			FilterQueryBuilder query = (FilterQueryBuilder)
					FilterQueryBuilder.create(this.TABLE_NAME)
					.addWhere("username", username, "s")
					.addLike("username", username, "s");


			ResultSet res = this.connection.executeQuery(query.getQuery(), query.getTypes(), query.getValues());
		
			if(res.next()) {
				return Login.createFromValues(
						res.getInt("id"),
						res.getString("username"),
						res.getString("salted_hash"),
						res.getString("salted")
						);
			}
			return null;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public boolean create(CreateUserDTO userDto) {
		try {
			InsertQueryBuilder query = (InsertQueryBuilder)
					InsertQueryBuilder.create("user")
					.add("id", 0, "i")
					.add("username", userDto.getEmri(), "s")
					.add("salted_hash", userDto.getSaltedHash(), "s")
					.add("salted", userDto.getSalted(), "s");
			
			int lastInsertedId = 
					this.connection.execute(
							query.getQuery(), query.getTypes(), query.getValues()
							);
			if (lastInsertedId > 0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
	
}