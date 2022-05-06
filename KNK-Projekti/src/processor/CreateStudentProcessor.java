package processor;

import model.Student;

public class CreateStudentProcessor {
	public Student generateStudent(Student student) {
		String studentId = "1506754213"; //GenerateStudentId.get();
		student.setStudentId(studentId);
		return student;
	}
}
