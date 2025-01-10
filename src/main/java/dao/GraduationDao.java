package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import common.DateExt;
import database.MsSqlConnection;
import dto.StudentGraduationInfo;

/**Class responsible for interacting with the database to add student graduation information.
 * 
 * 
 * @author Huynh Van Giang
 * @version 1.00
 */
public class GraduationDao{

	// instance of connection to database
	private Connection connect;
	
	// CallableStatement for executing stored procedures
	private CallableStatement ctm;
	
	// SQL query for calling the stored procedure
	private String sql;
	
	/**
     * Adds student graduation information to the database by calling a stored procedure.
     * 
     * @param request - Contains the student and graduation information to be inserted.
     * @return boolean - Returns true if the insertion was successful, false otherwise.
     * @throws ClassNotFoundException - If the JDBC driver class is not found.
     * @throws IOException - If an input/output error occurs during the connection.
     * @throws SQLException - If a SQL error occurs during the execution of the stored procedure.
     */
	public boolean addInformation(StudentGraduationInfo request) throws ClassNotFoundException, IOException, SQLException {
		
		// Establish the connection to the database
		connect = MsSqlConnection.getConnection();
		
		// The stored procedure to insert student graduation information
		sql = "sp_add_infor(?,?,?,?,?,?,?,?,?,?)";
		
		// keep track of the parameter index 
		int param = 0;
		
		// Variable to track if the insertion is successful
		boolean isSuccess = true;
		
		try {
			
			CallableStatement ctm = connect.prepareCall(sql);
			
			// Set the parameters for the stored procedure from the request object
			ctm.setString(++param, request.getStudent().getSoCMND());
			ctm.setString(++param, request.getStudent().getHoTen());
			ctm.setString(++param, request.getStudent().getEmail());
			ctm.setString(++param, request.getStudent().getSoDT());
			ctm.setString(++param, request.getStudent().getDiaChi());
			ctm.setString(++param, request.getGraduation().getMaTruong());
			ctm.setString(++param, request.getGraduation().getMaNganh());
			ctm.setString(++param, request.getGraduation().getHeTN());
			ctm.setDate(++param, DateExt.convertStringToDate(request.getGraduation().getNgayTN()));
			ctm.setString(++param, request.getGraduation().getLoaiTN());
			
			// Execute the stored procedure and check if it was successful
			isSuccess = ctm.executeUpdate() != 0;
		}
		finally {
			// Ensure the database connection is closed to avoid resource leaks
			try {
				if(connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}

}
