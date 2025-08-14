package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCustomerRequest {
    @JsonProperty("customerId")
    private String customerId;
   
    @JsonProperty("customerName")
    private String customerName;
    
    @JsonProperty("customerMobile")
    private String customerMobile;
    
    @JsonProperty("customerEmail")
    private String customerEmail;
    
    @JsonProperty("customeraddress")
    private String customeraddress;
    
    @JsonProperty("customerUsername")
    private String customerUsername;
    
    @JsonProperty("customerPassword")
    private String customerPassword;

    public AddCustomerRequest() {}

    public AddCustomerRequest(String customerId, String customerName, String customerMobile,
                              String customerEmail, String customeraddress,
                              String customerUsername, String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.customeraddress = customeraddress;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    // Getters & Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerMobile() { return customerMobile; }
    public void setCustomerMobile(String customerMobile) { this.customerMobile = customerMobile; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getCustomeraddress() { return customeraddress; }
    public void setCustomeraddress(String customeraddress) { this.customeraddress = customeraddress; }

    public String getCustomerUsername() { return customerUsername; }
    public void setCustomerUsername(String customerUsername) { this.customerUsername = customerUsername; }

    public String getCustomerPassword() { return customerPassword; }
    public void setCustomerPassword(String customerPassword) { this.customerPassword = customerPassword; }
}
