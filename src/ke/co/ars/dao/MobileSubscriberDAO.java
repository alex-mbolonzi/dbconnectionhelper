/**
 * @author Alex Mbolonzi
 * @date 19/08/2013
 */
package ke.co.ars.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ke.co.ars.entity.MobileSubscriber;

public class MobileSubscriberDAO {
    
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(MobileSubscriberDAO.class.getName());
    
    public MobileSubscriberDAO() {
        
      //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("/opt/log4j/forgeDBlog4j.properties");
        
    }    
    
    public MobileSubscriber findSubByMSISDN (String MSISDN){
        
        log.info("findByMSISDN()....");
        
        Connection conn = null;
        
        MobileSubscriber subscriber = new MobileSubscriber();
        // Step-1: identify the stored procedure
	    String getSubDetailsProc = "{ call get_subscriber_details(?) }";
        
        log.debug("Query : " + getSubDetailsProc);
        
        try {
        
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
            // Step-2: prepare the callable statement
    	    CallableStatement cs = conn.prepareCall(getSubDetailsProc);
    	    // Step-4: register output parameters ...
		    cs.setString(1,MSISDN);
    	    
		    // Step-5: execute the stored procedures: 
		    cs.execute();
		    
		    cs.close();
    	    
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            
            ConnectionHelper.close(conn);
        }
        
        return subscriber;
    }
    
    public void logSubscriber(MobileSubscriber subscriber) {
        
        log.info("addMobileSubscriber()....");
        
        Connection conn = null;
        
        // Step-1: identify the stored procedure
	    String logMobileSubProc = "{ call add_subscriber(?,?,?,?,?,?) }";
        
        log.debug("Query : " + logMobileSubProc);
            
        try {
            
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
            // Step-3: prepare the callable statement
		    CallableStatement cs = conn.prepareCall(logMobileSubProc);
		    // Step-4: register output parameters ...
		    cs.setString(1,subscriber.getMobileNumber());
		    cs.setString(2,subscriber.getName());
		    cs.setString(3,subscriber.getMNO());
		    cs.setString(4,subscriber.getCountryCode());
		    cs.setString(5,String.valueOf(subscriber.getStatus()));
		    cs.registerOutParameter(6, java.sql.Types.INTEGER);

		    // Step-4: execute the stored procedures
		    cs.execute();
		    
		    int subID = cs.getInt("sub_id");
		    
		    cs.close();
            
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            
            ConnectionHelper.close(conn);
        }
    }
}
