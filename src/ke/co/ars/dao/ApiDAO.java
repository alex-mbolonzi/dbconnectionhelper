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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ke.co.ars.entity.ApiInfo;
import ke.co.ars.entity.Transfer;

public class ApiDAO {
    
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(ApiDAO.class.getName());

    public ApiDAO() {
      //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("/opt/log4j/forgeDBlog4j.properties");
    }
    
    public ApiInfo getApiDetails(Transfer mpesaTransfer) {

        log.info("getServerDetails()....");
        
        ApiInfo apiDetails;

        Connection conn = null;

        String getApiInfoProc = "{ call get_mpesa_api_details(?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?) }";

        log.debug("Query : " + getApiInfoProc);
        
        try {

            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
         // Step-3: prepare the callable statement
		    CallableStatement cs = conn.prepareCall(getApiInfoProc);
		    
		    cs.setString(1,mpesaTransfer.getServerName());
		    cs.setString(2,mpesaTransfer.getTimestamp());
		    cs.setString(3,mpesaTransfer.getTransactionType());
		    cs.setString(4,mpesaTransfer.getDestAccount());
		    cs.setInt(5,Integer.valueOf(mpesaTransfer.getAmount()));
		    cs.setString(6,mpesaTransfer.getTrxCode());
		    cs.setString(7,mpesaTransfer.getSourceMSISDN());
		    cs.setInt(8,mpesaTransfer.getOrigID());
		    cs.setString(9,mpesaTransfer.getOrig());
		    cs.registerOutParameter(10, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(11, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(12, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(13, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(14, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(15, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(16, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(17, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(18, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(19, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(20, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(21, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(22, java.sql.Types.INTEGER);
		    cs.registerOutParameter(23, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(24, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(25, java.sql.Types.INTEGER);
		    cs.registerOutParameter(26, java.sql.Types.INTEGER);
		    cs.registerOutParameter(27, java.sql.Types.INTEGER);
		    cs.registerOutParameter(28, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(29, java.sql.Types.INTEGER);
		    cs.registerOutParameter(30, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(31, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(32, java.sql.Types.INTEGER);
		    cs.registerOutParameter(33, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(34, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(35, java.sql.Types.INTEGER);
		    cs.registerOutParameter(36, java.sql.Types.INTEGER);
		    cs.registerOutParameter(37, java.sql.Types.INTEGER);
		    cs.registerOutParameter(38, java.sql.Types.INTEGER);
		    cs.registerOutParameter(39, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(40, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(41, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(42, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(43, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(44, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(45, java.sql.Types.VARCHAR);
		    
		 // Step-5: execute the stored procedures: 
		    cs.execute();
            
		    int sqlState = cs.getInt("mpesa_sql_state");
		    
		    switch(sqlState){
	    	case 0:
	    		// Step-6: extract the output parameters
			    apiDetails = new ApiInfo();
	                 
			    apiDetails.setSp_id(cs.getString("mpesa_sp_id"));
			    apiDetails.setSp_password(cs.getString("mpesa_sp_password"));
			    apiDetails.setService_id(cs.getString("mpesa_service_id"));
			    apiDetails.setCommand_id(cs.getString("mpesa_command_id"));
			    apiDetails.setLanguage_code(cs.getString("mpesa_language_code"));
			    apiDetails.setQueue_timeout_url(cs.getString("mpesa_queue_timeout_url"));
			    apiDetails.setThird_party_id(cs.getString("mpesa_third_party_id"));
			    apiDetails.setCaller_password(cs.getString("mpesa_caller_password"));
			    apiDetails.setCheck_sum(cs.getString("mpesa_check_sum"));
			    apiDetails.setResult_url(cs.getString("mpesa_result_url"));
			    apiDetails.setRequestUrl(cs.getString("mpesa_request_url"));
			    apiDetails.setQueryTrxUrl(cs.getString("mpesa_query_trx_url"));
			    apiDetails.setIdentifier(String.valueOf(cs.getInt("mpesa_identifier")));
			    apiDetails.setInitiator_password(cs.getString("mpesa_initiator_password"));
			    apiDetails.setShort_code(cs.getString("mpesa_short_code"));
			    apiDetails.setPrimary_party_id(cs.getInt("mpesa_primary_party_id"));
			    apiDetails.setReceiver_id(cs.getInt("mpesa_receiver_id"));
			    apiDetails.setAccess_id(cs.getInt("mpesa_access_id"));
			    apiDetails.setAccess_identifier(cs.getString("mpesa_access_identifier"));
			    apiDetails.setKey_owner(cs.getInt("mpesa_key_owner"));
			    apiDetails.setKey_store(cs.getString("mpesa_key_store"));
			    apiDetails.setKey_store_password(cs.getString("mpesa_key_store_password"));
			    apiDetails.setCallerType(cs.getInt("mpesa_caller_type"));
			    apiDetails.setTrust_store(cs.getString("mpesa_trust_store"));
			    apiDetails.setTrust_store_password(cs.getString("mpesa_trust_store_password"));
			    apiDetails.setIdentifierType(cs.getInt("mpesa_identifier_type"));
			    apiDetails.setTransactionID(String.valueOf(cs.getInt("mpesa_transaction_id")));
			    apiDetails.setTimeout(cs.getInt("mpesa_tmieout"));
			    apiDetails.setInstitutionCode(cs.getString("mpesa_institution_code"));
			    apiDetails.setMerchantCode(cs.getString("mpesa_account_id"));
			    apiDetails.setCurrencyCode(cs.getString("mpesa_currency_code"));
			    apiDetails.setISOServerIP(cs.getString("mpesa_host_ip"));
			    apiDetails.setISOServerPort(Integer.valueOf(cs.getString("mpesa_host_port")));
			    apiDetails.setDebitAcc(cs.getString("mpesa_float_account"));
			    apiDetails.setStatusCode(0);
			    
	    	break;	
	    	case 23000:
	    		
	    		apiDetails = new ApiInfo();
	    		
	    		apiDetails.setStatusCode(94);
	    		
	    	break;
	    	default:
	    		
	    		apiDetails = new ApiInfo();
	    		
	    		apiDetails.setStatusCode(95);
	    		
	    	break;
	    	}
		 
		    

        } catch (SQLException e) {
            
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            
            ConnectionHelper.close(conn);
        }

        return apiDetails;
    }

}
