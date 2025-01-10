package dto;

/**
 * use for mapping data when save in form T001
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class StudentGraduationInfo {
	// detail information of student
	private Student student;
	
	// one of graduation record of student
	private Graduation graduation;
	
	/**
	 * @return student: Student
	 */
	public Student getStudent() {
		return student;
	}
	
	/**
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * @return graduation: Graduation
	 */
	public Graduation getGraduation() {
		return graduation;
	}
	
	/**
	 * @param graduation
	 */
	public void setGraduation(Graduation graduation) {
		this.graduation = graduation;
	}
}
