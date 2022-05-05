package repository;

import java.sql.ResultSet;
import java.sql.Statement;

import database.DBConnect;
import database.InsertQueryBuilder;
import model.Student;
import model.DTO.CreateUserDTO;

public class StudentRepository {

	private final String TABLE_NAME = "student";
	private DBConnect connection;
	
	public StudentRepository() {
		this.connection = DBConnect.getInstance();
	}
	
	public boolean create(Student student) {
		try {
			InsertQueryBuilder query = (InsertQueryBuilder)
					InsertQueryBuilder.create(this.TABLE_NAME)
					.add("id", student.getId(), "i")
					.add("emri", student.getEmri(), "s")
					.add("mbiemri", student.getMbiemri(), "s")
					.add("mosha", student.getMosha(), "i");
			
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
