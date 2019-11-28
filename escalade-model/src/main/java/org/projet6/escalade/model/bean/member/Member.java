package org.projet6.escalade.model.bean.member;

public class Member {
    private Integer id;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String postalCode;
    private String town;
    private Boolean isAdmin;

    public Member() {

    }

    public Member(Integer pId) {
        id = pId;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTown() {
        return town;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAdmin(Boolean isAdmin) { this.isAdmin = isAdmin; }
}