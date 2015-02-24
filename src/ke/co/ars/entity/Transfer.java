/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class Transfer extends StatusCode{

    private int transferID;
    
    private int hitsID;
    
    private int nodeID;
    
    private int origID;
    
    private String orig;
    
    private String businessNumber;
    
    private String timestamp;
    
    private String trxCode;
    
    private String destAccount;
    
    private String sourceMSISDN;
    
    private String amount;
    
    private String currencyCode;
    
    private String resultData;
    
//    private int status;
    
//    private String resultStatus;
    
    private String dateProcessed;
    
    private String traceNumber;
    
    private String description;
    
    private String serverName;
    
    private String transactionType;

    public int getTransferID() {
        return transferID;
    }

    public void setTransferID(int transferID) {
        this.transferID = transferID;
    }

    public int getHitsID() {
        return hitsID;
    }

    public void setHitsID(int hitsID) {
        this.hitsID = hitsID;
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getOrigID() {
        return origID;
    }

    public void setOrigID(int origID) {
        this.origID = origID;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(String destAccount) {
        this.destAccount = destAccount;
    }

    public String getSourceMSISDN() {
        return sourceMSISDN;
    }

    public void setSourceMSISDN(String sourceMSISDN) {
        this.sourceMSISDN = sourceMSISDN;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getResultStatus() {
//        return resultStatus;
//    }
//
//    public void setResultStatus(String resultStatus) {
//        this.resultStatus = resultStatus;
//    }

    public String getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(String dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
