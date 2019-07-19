package com.example.user.myapplication;

public class UserInfoD {
    private String CompanyId;
    private String Fullname;
    private String Email;
    private String Designation;
    private String Department;
    private String Phone;
    private String Password;
    private String Address;
    private String City;
    private String Country;
    private String hireDate;
    public UserInfoD() {
    }

    public UserInfoD(String companyId, String fullname, String email, String designation, String department, String phone, String password, String address, String city,String country, String Hiredate) {
        CompanyId = companyId;
        Fullname = fullname;
        Email = email;
        Designation = designation;
        Department = department;
        Phone = phone;
        Password = password;
        Address=address;
        City=city;
        Country=country;
        hireDate=Hiredate;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress(){return Address;}
    public  void setAddress(String address){Address=address;}

    public String getCity(){return City;}
    public  void setCity(String city){City=city;}


    public String getCountry(){return Country;}
    public  void setCountry(String country){Country=country;}

    public String getHireDate(){return hireDate;}
    public void setHireDate(String Hiredate){hireDate=Hiredate;}
}
