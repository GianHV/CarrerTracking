package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class provides functionality to establish a connection to a SQL Server
 * database using the provided configuration settings.
 * 
 * It loads the database connection configurations from a properties file and 
 * creates a connection to the SQL Server using the loaded settings.
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class MsSqlConnection {

	// url information of sql server
	private static String url;

	// username of user for login
	private static String username;

	// password of user for login
	private static String password;

	// Library for sql server
	private static String lib;

	 /**
     * Establishes a connection to the SQL Server database using the loaded 
     * configuration settings.
     * 
     * @return Connection object for interacting with the database
     * @throws ClassNotFoundException if the JDBC driver class is not found
     * @throws IOException if there is an issue reading the configuration file
     * @throws SQLException if a database access error occurs
     */
	public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		// Load the configuration settings from the properties file
		loadConfigurations();

		// Register the JDBC driver for SQL Server
		Class.forName(lib);
		
		// Establish and return a connection to the database
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	/**
	 * Loads the database connection configurations from a properties file. The
	 * properties file is expected to be located in the resources folder.
	 * 
	 * @throws IOException if there is an error loading the configuration file
	 */
	private static void loadConfigurations() throws IOException {
		// Create a Properties object to store the loaded configurations
		Properties properties = new Properties();
		
		// Load the properties file located in the resources folder
		properties.load(MsSqlConnection.class.getResourceAsStream("../config.properties"));
		
		// Retrieve and store the necessary properties for the database connection
		lib = properties.getProperty("db.lib");
		username = properties.getProperty("db.user");
		password = properties.getProperty("db.password");
		url = properties.getProperty("db.url");
	}
}
