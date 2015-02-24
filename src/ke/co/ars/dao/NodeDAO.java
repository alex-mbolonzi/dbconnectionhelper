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
//import java.util.ArrayList;
//import java.util.List;




import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ke.co.ars.dao.ConnectionHelper;
import ke.co.ars.entity.TrxResponse;
import ke.co.ars.entity.Node;

public class NodeDAO {
    
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(NodeDAO.class.getName());

    public NodeDAO() {
      //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("/opt/log4j/forgeDBlog4j.properties");
    }
    
    public Node getServerDetails(String serverName) {

        log.info("getServerDetails()....");
        
        Node nodeDetails;

        Connection conn = null;

     // Step-1: identify the stored procedure
	    String getNodeDetailsProc = "{ call get_node_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

        log.debug("Query : " + getNodeDetailsProc);
        
        try {

            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
         // Step-3: prepare the callable statement
		    CallableStatement cs = conn.prepareCall(getNodeDetailsProc);
		    // Step-4: register output parameters ...
		    cs.setString(1, serverName);
		    cs.registerOutParameter(2, java.sql.Types.INTEGER);
		    cs.registerOutParameter(3, java.sql.Types.INTEGER);
		    cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(5, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(6, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(7, java.sql.Types.INTEGER);
		    cs.registerOutParameter(8, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(9, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(10, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(11, java.sql.Types.INTEGER);
		    cs.registerOutParameter(12, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(13, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(14, java.sql.Types.VARCHAR);
		    // Step-5: execute the stored procedures: 
		    cs.execute();
           
		    nodeDetails = new Node();
		 // Step-6: extract the output parameters
		    nodeDetails.setNodeID(cs.getInt("nodeID"));
		    nodeDetails.setAccountcode(String.valueOf(cs.getInt("extAccID")));
		    nodeDetails.setNodeName(cs.getString("nodeName"));
		    nodeDetails.setNodeIP(cs.getString("hostIP"));
		    nodeDetails.setNodePort(Integer.valueOf(cs.getString("hostPort")));
		    nodeDetails.setTimeout(cs.getInt("timeOut"));
		    nodeDetails.setUsername(cs.getString("uName"));
		    nodeDetails.setPassword(cs.getString("pwd"));
		    nodeDetails.setUrl(cs.getString("nodeURL"));
		    nodeDetails.setStatusCode(cs.getInt("nodeStatus"));
		    nodeDetails.setInstitutionCode(cs.getString("instCode"));
//		    String accID = cs.getString("accID");
//		    String currencyCode = cs.getString("currencyCode");
		    
		    cs.close();
		    
        } catch (SQLException e) {
        	
        	nodeDetails = new Node();
        	
            nodeDetails.setStatusCode(95);
            
            nodeDetails.setStatusDescription("ERROR: Unable to login to DB");
            
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            
            ConnectionHelper.close(conn);
        }

        return nodeDetails;
    }

    public void updateEchoStatus(Node nodeStatus) {

        log.info("updateNodeStatus()....");
        
        Connection conn = null;
        
     // Step-1: identify the stored procedure
	    String updateNodeDetailsProc = "{ call update_node_status(?,?,?) }";

        log.debug("Query : " + updateNodeDetailsProc);

        
        try {
            
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();

            // Step-3: prepare the callable statement
		    CallableStatement cs = conn.prepareCall(updateNodeDetailsProc);
		    // Step-4: register output parameters ...
		    cs.setString(1, String.valueOf(nodeStatus.getStatusCode()));
		    cs.setString(2, nodeStatus.getStatusDescription());
		    cs.setString(3, nodeStatus.getNodeName());

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
