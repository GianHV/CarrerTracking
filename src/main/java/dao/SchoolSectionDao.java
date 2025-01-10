package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.MsSqlConnection;
import dto.School;
import dto.SchoolSection;
import dto.Section;

/**
 * This class is responsible for interacting with the database to fetch school and section data.
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class SchoolSectionDao {
	// instance of connection to database
	private Connection connect;

	// CallableStatement is used to execute stored procedures
	CallableStatement stmt = null;

	// ResultSets to hold the data returned by the stored procedure
	ResultSet rs1 = null, rs2 = null;

	// SQL query for calling the stored procedure
	private String sql;

	 /**
     * This method calls the stored procedure "sp_get_schoolsection" from the database
     * and processes the results into School and Section objects.
     * 
     * @return A populated SchoolSection object containing schools and sections data.
     * @throws ClassNotFoundException if the JDBC driver class is not found.
     * @throws IOException if there is an error with input/output operations.
     * @throws SQLException if there is an issue with SQL execution.
     */
	public SchoolSection getSchoolSections() throws ClassNotFoundException, IOException, SQLException {
		// Establish the connection to the database
		connect = MsSqlConnection.getConnection();

		// The stored procedure to fetch school and section data
		sql = "sp_get_schoolsection";

		// Create an empty SchoolSection object to store the results
		SchoolSection result = new SchoolSection();

		try {
			stmt = connect.prepareCall(sql);

			// Execute the stored procedure and check if results are returned
			boolean hadResults = stmt.execute();
			
			// If there are results, process the first result set (school data)
			if (hadResults) {
                rs1 = stmt.getResultSet();
                while (rs1.next()) {
                	// Create School objects and add them to the result list
                	School school = new School(rs1.getString("MaTruong"), rs1.getString("TenTruong"));
                	result.schools.add(school);
                }
            }
			
			// If there are more results, process the second result set (section data)
			if (stmt.getMoreResults()) {
                rs2 = stmt.getResultSet();
                while (rs2.next()) {
                	// Create Section objects and add them to the result list
                	Section section = new Section(rs2.getString("maNganh"), rs2.getString("tenNganh"));
                	result.sections.add(section);
                }
            }
		} finally {
			try {
				// Ensure resources are closed to prevent memory leaks
				if (rs1 != null) rs1.close();
	            if (rs2 != null) rs2.close();
				if (stmt != null) stmt.close();
				if (connect != null) connect.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
