package repository;

import java.sql.ResultSet;

import database.DBConnect;
import database.FilterQueryBuilder;
import model.Login;

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
					.addWhere("username", username, "s");
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
			return null;
		}
	}
}