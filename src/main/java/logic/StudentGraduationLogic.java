package logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import common.Constants;
import common.DateExt;
import common.StringExt;
import dao.SchoolSectionDao;
import dto.Graduation;
import dto.SchoolSection;
import dto.Student;
import dto.StudentGraduationInfo;

/**
 * This class contains the business logic for handling student graduation information.
 * It interacts with the SchoolSectionDao to retrieve school section data.
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class StudentGraduationLogic {
	
	//  Instance of SchoolSectionDao to handle database operations related to school sections.	
	private SchoolSectionDao schoolSection = new SchoolSectionDao();
	
	/**
     * This method retrieves the school sections data by calling the getSchoolSections method from SchoolSectionDao.
     * 
     * @return SchoolSection object containing the school sections information.
     * @throws ClassNotFoundException If the JDBC driver class is not found.
     * @throws IOException If an I/O error occurs while retrieving the data.
     * @throws SQLException If a database access error occurs while querying the data.
     */
	public SchoolSection getSchoolSections() throws ClassNotFoundException, IOException, SQLException {
		return schoolSection.getSchoolSections();
	}
	
	/**
	 * Validates the input data from an HTTP request.
	 * 
	 * @param request The HTTP request object containing input parameters.
	 * @return A string message indicating validation errors, or an empty string if all inputs are valid.
	 */
	public String isValidData(HttpServletRequest request) {
		String reqSoCMND = request.getParameter("soCMND");
		String reqMaTruong = request.getParameter("maTruong");
		String reqMaNganh = request.getParameter("maNganh");
		String reqNgayTN = request.getParameter("ngayTN");
		
		if(StringExt.isNullOrEmpty(reqSoCMND)) {
			return Constants.T001_ERROR_MESSAGE1;
		}
		if(StringExt.isNullOrEmpty(reqMaTruong)) {
			return Constants.T001_ERROR_MESSAGE2;
		}
		if(StringExt.isNullOrEmpty(reqMaNganh)) {
			return Constants.T001_ERROR_MESSAGE3;
		}
		if(!DateExt.isValidDate(reqNgayTN)) {
			return Constants.T001_ERROR_MESSAGE4;
		}
		
		return Constants.EMPTY_STRING;
	}
	
	/**
	 * Populates a `StudentGraduationInfo` object with data from the HTTP request.
	 * 
	 * @param request The HTTP request containing student and graduation information.
	 * @return A `StudentGraduationInfo` object with the student and graduation details.
	 */
	public StudentGraduationInfo validateInformation(HttpServletRequest request) {
		StudentGraduationInfo result = new StudentGraduationInfo();
		
		// Populate the Student object with request parameters
		Student student = new Student();
		student.setSoCMND(request.getParameter("soCMND"));
		student.setHoTen(request.getParameter("hoTen"));
		student.setEmail(request.getParameter("email"));
		student.setSoDT(request.getParameter("soDT"));
		student.setDiaChi(request.getParameter("diaChi"));
		
		// Populate the Graduation object with request parameters
		Graduation graduation = new Graduation();
		graduation.setSoCMND(request.getParameter("soCMND"));
		graduation.setMaTruong(request.getParameter("maTruong"));
		graduation.setMaNganh(request.getParameter("maNganh"));
		graduation.setHeTN(request.getParameter("heTN"));
		// Convert date format from "dd/MM/yyyy" to "yyyy-MM-dd"
		graduation.setNgayTN(request.getParameter("ngayTN").replace("/", "-"));
		graduation.setLoaiTN(request.getParameter("loaiTN"));
		
		// Set the student and graduation information in the result
		result.setGraduation(graduation);
		result.setStudent(student);
		
		return result;
	}
}
