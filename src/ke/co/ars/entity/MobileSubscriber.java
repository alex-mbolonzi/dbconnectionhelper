/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class MobileSubscriber {

    private int mobileId;
    
    private String mobileNumber;
    
    private String name;
    
    private String MNO;
    
    private String countryCode;
    
    private int status;
    
    private String transactionId;

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMNO() {
        return MNO;
    }

    public void setMNO(String mNO) {
        MNO = mNO;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    
}
