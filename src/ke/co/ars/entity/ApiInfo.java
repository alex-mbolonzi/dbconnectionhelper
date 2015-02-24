/*
    Author: Alex Mbolonzi

 */
package ke.co.ars.entity;

public class ApiInfo extends TrxRequest{
    
    private String sp_id;
    
    private String sp_password;
    
    private String service_id;
    
    private String command_id;
    
    private String language_code;
    
    private String queue_timeout_url;
    
    private String third_party_id;
    
    private String caller_password;
    
    private String check_sum;
    
    private String result_url;
    
    private String requestUrl;
    
    private String queryTrxUrl;
    
    private String identifier;
    
    private String initiator_password;
    
    private String short_code;
    
    private int primary_party_id;
    
    private int receiver_id;
    
    private int access_id;
    
    private String access_identifier;
    
    private int key_owner;
    
    private String key_store;
    
    private String key_store_password;
    
    private String trust_store;
    
    private String trust_store_password;
    
    private int callerType;
    
    private int identifierType;
    
    public String getSp_id() {
        return sp_id;
    }
    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }
    public String getSp_password() {
        return sp_password;
    }
    public void setSp_password(String sp_password) {
        this.sp_password = sp_password;
    }
    public String getService_id() {
        return service_id;
    }
    public void setService_id(String service_id) {
        this.service_id = service_id;
    }
    public String getCommand_id() {
        return command_id;
    }
    public void setCommand_id(String command_id) {
        this.command_id = command_id;
    }
    public String getLanguage_code() {
        return language_code;
    }
    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    public String getQueue_timeout_url() {
        return queue_timeout_url;
    }
    public void setQueue_timeout_url(String queue_timeout_url) {
        this.queue_timeout_url = queue_timeout_url;
    }
    public String getThird_party_id() {
        return third_party_id;
    }
    public void setThird_party_id(String third_party_id) {
        this.third_party_id = third_party_id;
    }
    public String getCaller_password() {
        return caller_password;
    }
    public void setCaller_password(String caller_password) {
        this.caller_password = caller_password;
    }
    public String getCheck_sum() {
        return check_sum;
    }
    public void setCheck_sum(String check_sum) {
        this.check_sum = check_sum;
    }
    public String getResult_url() {
        return result_url;
    }
    public void setResult_url(String result_url) {
        this.result_url = result_url;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getInitiator_password() {
        return initiator_password;
    }
    public void setInitiator_password(String initiator_password) {
        this.initiator_password = initiator_password;
    }
    public String getShort_code() {
        return short_code;
    }
    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }
    public int getPrimary_party_id() {
        return primary_party_id;
    }
    public void setPrimary_party_id(int primary_party_id) {
        this.primary_party_id = primary_party_id;
    }
    public int getReceiver_id() {
        return receiver_id;
    }
    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }
    public int getAccess_id() {
        return access_id;
    }
    public void setAccess_id(int access_id) {
        this.access_id = access_id;
    }
    public String getAccess_identifier() {
        return access_identifier;
    }
    public void setAccess_identifier(String access_identifier) {
        this.access_identifier = access_identifier;
    }
    public int getKey_owner() {
        return key_owner;
    }
    public void setKey_owner(int key_owner) {
        this.key_owner = key_owner;
    }
    public String getKey_store() {
        return key_store;
    }
    public void setKey_store(String key_store) {
        this.key_store = key_store;
    }
    public String getKey_store_password() {
        return key_store_password;
    }
    public void setKey_store_password(String key_store_password) {
        this.key_store_password = key_store_password;
    }
    public String getTrust_store() {
        return trust_store;
    }
    public void setTrust_store(String trust_store) {
        this.trust_store = trust_store;
    }
    public String getTrust_store_password() {
        return trust_store_password;
    }
    public void setTrust_store_password(String trust_store_password) {
        this.trust_store_password = trust_store_password;
    }
    public String getRequestUrl() {
        return requestUrl;
    }
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
    public String getQueryTrxUrl() {
        return queryTrxUrl;
    }
    public void setQueryTrxUrl(String queryTrxUrl) {
        this.queryTrxUrl = queryTrxUrl;
    }
    public int getCallerType() {
        return callerType;
    }
    public void setCallerType(int callerType) {
        this.callerType = callerType;
    }
    public int getIdentifierType() {
        return identifierType;
    }
    public void setIdentifierType(int identifierType) {
        this.identifierType = identifierType;
    }
}
