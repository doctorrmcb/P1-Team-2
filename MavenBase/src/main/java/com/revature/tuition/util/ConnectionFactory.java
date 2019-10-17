package com.revature.tuition.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private static String url;
	
	private static String user;
	
	private static String password;
	
	private static final String PROJECT_ROOT_DIRECTORY = "C:\\Users\\Michael\\Documents\\P1-Team-2\\MavenBase\\src\\main\\webapp";
	
	private static final String PROPERTIES_FILE = PROJECT_ROOT_DIRECTORY + "\\database.properties";
	
	private static ConnectionFactory connectionFactory;
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		
		if (connection == null) {
			connection = connectionFactory.createConnection();
		}
		
		return connection;
	}
	
	
	private ConnectionFactory() {
		
		Properties properties = new Properties();
		
		try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
			
			properties.load(fis);
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(PROPERTIES_FILE);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Connection createConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
}
