package logic;

import java.io.IOException;
import java.sql.SQLException;

import dao.SchoolSectionDao;
import dto.SchoolSection;

/**
 * This class contains the business logic for handling student graduation information.
 * It interacts with the SchoolSectionDao to retrieve school section data.
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class StudentGraduationLogic {
	
	// Create an instance of the SchoolSectionDao class to access the database for school sections
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
}
