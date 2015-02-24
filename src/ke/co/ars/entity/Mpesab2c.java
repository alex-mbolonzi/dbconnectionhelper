/**
 * @author Alex Mbolonzi
 * @date 19/08/2013
 */
package ke.co.ars.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mpesab2c {

    private int idB2C;
    
    private int origID;
    
    private String orig;
    
    private String businessNumber;
    
    private String origTimeStamp;
    
    private String origSMSText;
    
    private String origTrxCode;
    
    private String destAccountNumber;
    
    private String senderMSISDN;
    
    private String origTrxDate;
    
    private String origTrxTime;
    
    private String amount;
    
    private int collectorID;
    
    private String senderName;
    
    private String currency;
    
    private String dateCreated;
    
    private String dateModified;
    
    private int status;
    
    private String traceNumber;
    
    public int getIdC2B() {
        return idB2C;
    }
    
    public void setIdC2B(int idC2B) {
        this.idB2C = idC2B;
    }

    public String getSenderMSISDN() {
        return senderMSISDN;
    }

    public void setSenderMSISDN(String senderMSISDN) {
        this.senderMSISDN = senderMSISDN;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getCollectorID() {
        return collectorID;
    }

    public void setCollectorID(int collectorID) {
        this.collectorID = collectorID;
    }

    public String getDestAccountNumber() {
        return destAccountNumber;
    }

    public void setDestAccountNumber(String destAccountNumber) {
        this.destAccountNumber = destAccountNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getOrigTrxCode() {
        return origTrxCode;
    }

    public void setOrigTrxCode(String origTrxCode) {
        this.origTrxCode = origTrxCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrigTimeStamp() {
        return origTimeStamp;
    }

    public void setOrigTimeStamp(String origTimeStamp) {
        this.origTimeStamp = origTimeStamp;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getOrigSMSText() {
        return origSMSText;
    }

    public void setOrigSMSText(String origSMSText) {
        this.origSMSText = origSMSText;
    }

    public String getOrigTrxDate() {
        return origTrxDate;
    }

    public void setOrigTrxDate(String origTrxDate) {
        this.origTrxDate = origTrxDate;
    }

    public String getOrigTrxTime() {
        return origTrxTime;
    }

    public void setOrigTrxTime(String origTrxTime) {
        this.origTrxTime = origTrxTime;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }
}
