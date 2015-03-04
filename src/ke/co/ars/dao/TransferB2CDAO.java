/**
 * @author Alex Mbolonzi
 * @date 19/08/2013
 */
package ke.co.ars.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import ke.co.ars.entity.StatusCode;
//import ke.co.ars.entity.Mpesab2c;
import ke.co.ars.entity.TrxRequest;
import ke.co.ars.entity.TrxResponse;
import ke.co.ars.entity.TrxResult;
import ke.co.ars.entity.Transfer;


public class TransferB2CDAO {
    
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(TransferB2CDAO.class.getName());
    
    public TransferB2CDAO() {
        
        //PropertiesConfigurator is used to configure logger from properties file
        
        PropertyConfigurator.configure("/opt/log4j/forgeDBlog4j.properties");
    }
       
    public TrxRequest logTransaction(Transfer transaction) {
        
          log.info("logTransaction()....");
        
        Connection conn = null;
        
        TrxRequest nodeTransaction;

        // Step-1: identify the stored procedure
	    String logMpaymentReqProc = "{ call log_mpayment_request(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
  
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        try {
            
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
            // Step-2: prepare the callable statement
    	    CallableStatement cs = conn.prepareCall(logMpaymentReqProc);
    	    
            log.debug("Query : " + logMpaymentReqProc);
            
//            log.info("Server name : " + transaction.getServerName() + 
//            		" dest acc " + transaction.getDestAccount() + 
//            		" amount " + transaction.getAmount() + 
//            		" trx code " + transaction.getTrxCode());
            
         // Step-4: register output parameters ...
		    cs.setString(1, transaction.getServerName());
		    cs.setString(2, date.toString());
		    cs.setString(3, transaction.getTransactionType());
		    cs.setString(4, transaction.getDestAccount());
		    cs.setString(5, transaction.getAmount());
		    cs.setString(6, transaction.getTrxCode());
		    cs.setString(7, transaction.getSourceMSISDN());
		    cs.setString(8, String.valueOf(transaction.getOrigID()));
		    cs.setString(9, transaction.getOrig());
		    cs.registerOutParameter(10, java.sql.Types.INTEGER);
		    cs.registerOutParameter(11, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(12, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(13, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(14, java.sql.Types.INTEGER);
		    cs.registerOutParameter(15, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(16, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(17, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(18, java.sql.Types.VARCHAR);
		    cs.registerOutParameter(19, java.sql.Types.INTEGER);
		    
		    // Step-4: execute the stored procedures
		    cs.execute();
		    
		    int sql_state = cs.getInt("sql_state");
//		    int transactionID = cs.getInt("trxID");
		    
		    nodeTransaction = new TrxRequest();
		    
//		    switch (transactionID){
//		    case 0:
		    	
		    	switch(sql_state){
		    	case 0:
		    	
		    		 nodeTransaction.setTransactionID(String.valueOf(cs.getInt("trxID")));
			    	 nodeTransaction.setInstitutionCode(cs.getString("inst_code"));
			    	 nodeTransaction.setMerchantCode(cs.getString("acc_id"));
			    	 nodeTransaction.setCurrencyCode(cs.getString("currency_code"));
			    	 nodeTransaction.setTimeout(cs.getInt("time_out"));
			    	 nodeTransaction.setISOServerIP(cs.getString("host_ip"));
			    	 nodeTransaction.setISOServerPort(Integer.valueOf(cs.getString("host_port")));
			    	 nodeTransaction.setDebitAcc(cs.getString("float_account"));
			    	 nodeTransaction.setStatusCode(0);
			    	 
		    	break;	
		    	case 23000:
		    		nodeTransaction.setStatusCode(94);
		    	break;
		    	default:
		    		nodeTransaction.setStatusCode(95);
		    	break;
		    	}
		    	
		    	    
//		     break;
//		     default:
		    	 
		    	 
//				    String comm_bank_acc = cs.getString("comm_account");
//		     break;
//		    }
		    
		    cs.close();

        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            
            ConnectionHelper.close(conn);
        }
//        }
        return nodeTransaction;
    }
    
    public void updateTransactionResponse(TrxResponse transactionResponse){
    	
    	log.info("updateTransactionResponse()....");
        
        Connection conn = null;
    	
     // Step-1: identify the stored procedure
	    String updateMobileTrxProc = "{ call update_mobile_transaction(?,?,?,?,?,?,?) }";
	    
	    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
	    
	    try {
            
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
            // Step-2: prepare the callable statement
    	    CallableStatement cs = conn.prepareCall(updateMobileTrxProc);
    	    
            log.debug("Query : " + updateMobileTrxProc);
            
            // Step-4: register output parameters ...
		    cs.setString(1, transactionResponse.getTransactionID());
		    cs.setString(2, "0");
		    cs.setString(3, transactionResponse.getStatusDescription());
		    cs.setString(4, transactionResponse.getTransactionData());
		    cs.setString(5, transactionResponse.getTraceNumber());
		    cs.setString(6, String.valueOf(transactionResponse.getStatusCode()));
		    cs.setString(7, date.toString());
		    
		    // Step-4: execute the stored procedures
		    cs.execute();
		    
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
    
    public void updateTransactionResult(TrxResult transactionResult){
    	
    	log.info("updateTransactionResult()....");
        
        Connection conn = null;
    	
     // Step-1: identify the stored procedure
	    String updateMobileResultTrxProc = "{ call update_transaction_result(?,?,?) }";
	        
	    try {
            
            log.info("Opening DB connection...");
            
            conn = ConnectionHelper.getConnection();
            
            // Step-2: prepare the callable statement
    	    CallableStatement cs = conn.prepareCall(updateMobileResultTrxProc);
    	    
            log.debug("Query : " + updateMobileResultTrxProc);
            
            // Step-4: register output parameters ...
		    cs.setString(1, transactionResult.getTransactionID());
		    cs.setString(2, String.valueOf(transactionResult.getStatusCode()));
		    cs.setString(3, transactionResult.getStatusDescription());
		    
		    // Step-4: execute the stored procedures
		    cs.execute();
		    
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
    
    public StatusCode findTransactionStatus (String transactionID,int sourceID,int functionCode){
        
        Connection conn = null;
        
        String getTransactionStatusProc = "{ call get_transaction_status_by_origin_id(?,?,?,?,?) }";
        
        StatusCode transactionStatus;
        
        try {
            
            conn = ConnectionHelper.getConnection();
            CallableStatement cs = conn.prepareCall(getTransactionStatusProc);
            cs.setString(1,transactionID);
            cs.setInt(2, sourceID);
            cs.setInt(3, functionCode);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.registerOutParameter(5, java.sql.Types.VARCHAR);
            cs.execute();
            
            transactionStatus = new StatusCode();
            
            transactionStatus.setStatusCode(cs.getInt("status_code"));
            transactionStatus.setStatusDescription(cs.getString("status_desc"));
            
            cs.close();
            
        } catch (Exception e) {
//          e.printStackTrace();
          log.error("Exception: ",e.fillInStackTrace());
          throw new RuntimeException(e);
      } finally {
          
          log.info("Closing DB connection...");
          
          ConnectionHelper.close(conn);
      }
        
        return transactionStatus;
    }
}
