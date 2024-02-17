package ru.mail.desktopandroidapp.models;

public class Doctor {
    private String firstname;
    private String lastname;
    private String middlename;
    private String password;
    private int doctor_type_id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDoctor_type_id() {
        return doctor_type_id;
    }

    public void setDoctor_type_id(int doctor_type_id) {
        this.doctor_type_id = doctor_type_id;
    }
}
