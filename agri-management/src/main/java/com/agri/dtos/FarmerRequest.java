package com.agri.dtos;

import jakarta.validation.constraints.*;

public class FarmerRequest {
    @NotBlank private String name;
    @NotBlank @Pattern(regexp="^[0-9]{10}$") private String phone;
    @Email private String email;
    private String address;

    public FarmerRequest() {}
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
