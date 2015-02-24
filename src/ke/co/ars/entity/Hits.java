/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class Hits {
    
    private int hitsID;
    
    private String timestamp;
    
    private String trxType;
    
    private String payload;

    public int getHitsID() {
        return hitsID;
    }

    public void setHitsID(int hitsID) {
        this.hitsID = hitsID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
