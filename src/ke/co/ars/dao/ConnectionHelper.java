package ke.co.ars.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConnectionHelper
{
	private String url;
	private static ConnectionHelper instance;
	public static String USER = null;
    public static String PASSWORD = null;

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(ConnectionHelper.class.getName());


	private ConnectionHelper()
	{
    	String driver = null;
    	
    	//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("/opt/log4j/forgeDBlog4j.properties");
    	
		try {
		    
		    Properties prop=new Properties();
		    
		    log.info("Loading DB properties...");
		    
	        prop.load(new FileInputStream("/opt/mysqlDB/forgeDBConnection.properties"));
	                
	        driver = prop.getProperty("jdbc.driver");
	        url = prop.getProperty("jdbc.url");
	        USER = prop.getProperty("jdbc.username");
	        PASSWORD = prop.getProperty("jdbc.password");
	        Class.forName(driver);
			
		} catch (Exception e) {
		    
		    log.error("Exception: ",e.fillInStackTrace());
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.url,USER,PASSWORD);
		} catch (SQLException e) {
		    
		    log.error("Exception: ",e.fillInStackTrace());
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		    log.error("Exception: ",e.fillInStackTrace());
		}
	}

}