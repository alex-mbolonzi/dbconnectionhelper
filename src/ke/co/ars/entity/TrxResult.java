/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class TrxResult extends StatusCode{

    private String transactionID;
    
    private String msisdn;
    
//    private String status;
    
//    private String statusDescription;
    
    private String transactionData;
    
    private String traceNumber;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatusDescription() {
//        return statusDescription;
//    }
//
//    public void setStatusDescription(String statusDescription) {
//        this.statusDescription = statusDescription;
//    }

    public String getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(String transactionData) {
        this.transactionData = transactionData;
    }

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
    
    
}
