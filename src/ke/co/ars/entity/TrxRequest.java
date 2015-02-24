/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class TrxRequest extends StatusCode{

    private String transactionID;
    
    private String msisdn;
    
    private String amount;
    
    private String transactionType;
    
    private String InstitutionCode;
    
    private String merchantCode;
    
    private String currencyCode;
    
    private String serverIP;
    
    private int serverPort;
    
    private int timeout;
    
    private String debitAcc;
    
    private String creditAcc;
    
    private String beneficiaryName;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getInstitutionCode() {
        return InstitutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        InstitutionCode = institutionCode;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getISOServerIP() {
        return serverIP;
    }

    public void setISOServerIP(String iSOServerIP) {
        serverIP = iSOServerIP;
    }

    public int getISOServerPort() {
        return serverPort;
    }

    public void setISOServerPort(int iSOServerPort) {
        serverPort = iSOServerPort;
    }

	public String getDebitAcc() {
		return debitAcc;
	}

	public void setDebitAcc(String debitAcc) {
		this.debitAcc = debitAcc;
	}

	public String getCreditAcc() {
		return creditAcc;
	}

	public void setCreditAcc(String creditAcc) {
		this.creditAcc = creditAcc;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
}
