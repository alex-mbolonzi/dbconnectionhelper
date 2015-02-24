/**
 * @author Alex Mbolonzi
 * @date 19/08/2013
 */
package ke.co.ars.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ke.co.ars.entity.TrxRequest;
import ke.co.ars.entity.StatusCode;



public class OracleTransferB2CDAO {
    
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(OracleTransferB2CDAO.class.getName());
    
    public OracleTransferB2CDAO() {
        
        //PropertiesConfigurator is used to configure logger from properties file
        
        PropertyConfigurator.configure("/opt/log4j/abc_oracle_DBlog4j.properties");
    }
    
    public StatusCode addMpesaC2BTrx(TrxRequest mpesaTrx) {
        
        log.info("addMpesaC2BTrx()...");
        
        Connection conn = null;
        
        PreparedStatement ps = null;
        
        StatusCode trxStatus;
        
        String sql = "INSERT INTO POAPAY_TBL (DEBIT_ACCOUNT,PHONE_NUM,AMOUNT,NETTELLER_UTN,CURRENCY,STATUS,BENEFICIARY_NAME,STAN) "
        		+ "VALUES(?,?,?,?,?,?,?,?)";
        
        log.debug("Query : " + sql);
        
        
//        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        int result = 0;
        
            
        try {
            
            log.info("Opening DB connection...");
            
            conn = OracleConnectionHelper.getConnection();
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, mpesaTrx.getDebitAcc());
            ps.setString(2, mpesaTrx.getMsisdn());
            ps.setString(3, mpesaTrx.getAmount());
            ps.setString(4, "NWPP" + mpesaTrx.getTransactionID());
            ps.setString(5, mpesaTrx.getCurrencyCode());
            ps.setString(6, "N");
            ps.setString(7, mpesaTrx.getBeneficiaryName());
            ps.setString(8, mpesaTrx.getTransactionID());
            
            result = ps.executeUpdate();
            
            trxStatus = new StatusCode();
            
            if(result > 0){
                
            	trxStatus.setStatusCode(0);
            	trxStatus.setStatusDescription("Accepted");;
                
            }else {
             // Failed to log the request in DB.
            	trxStatus.setStatusCode(95);
            	trxStatus.setStatusDescription("Could not log your request. Try again");
            }

        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Exception: ",e.fillInStackTrace());
            throw new RuntimeException(e);
        } finally {
            
            log.info("Closing DB connection...");
            OracleConnectionHelper.close(conn);
        }
        
        
        return trxStatus;
    }
}
