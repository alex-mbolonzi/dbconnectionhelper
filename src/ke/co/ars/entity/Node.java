/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class Node extends StatusCode{
    
    private int nodeID;
    
    private String nodeName;
    
    private String nodeIP;
    
    private int nodePort;
    
    private int timeout;
    
    private String url;
    
//    private int Status;
    
    private String username;
    
    private String password;
    
    private String institutionCode;
    
    private String accountcode;
    
    private String currencyCode;
    
//    private String statusDescription;
    
    private String debitAcc;
    
    private String creditAcc;
    
    private String nodeTransactionID;

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeIP() {
        return nodeIP;
    }

    public void setNodeIP(String nodeIP) {
        this.nodeIP = nodeIP;
    }

    public int getNodePort() {
        return nodePort;
    }

    public void setNodePort(int nodePort) {
        this.nodePort = nodePort;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public int getStatus() {
//        return Status;
//    }
//
//    public void setStatus(int status) {
//        Status = status;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

//    public String getStatusDescription() {
//        return statusDescription;
//    }
//
//    public void setStatusDescription(String statusDescription) {
//        this.statusDescription = statusDescription;
//    }

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

	public String getNodeTransactionID() {
		return nodeTransactionID;
	}

	public void setNodeTransactionID(String nodeTransactionID) {
		this.nodeTransactionID = nodeTransactionID;
	}

}
