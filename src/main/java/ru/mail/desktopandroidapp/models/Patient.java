package ru.mail.desktopandroidapp.models;

import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;

public class Patient {

    private int patientId;

    private String firstname;
    private String lastname;
    private String middlename;
    private String work_place;
    private String passport;
    private String polic;
    private int policDays;
    private String policCompany;
    private String medcardId;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

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

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPolic() {
        return polic;
    }

    public void setPolic(String polic) {
        this.polic = polic;
    }

    public int getPolicDays() {
        return policDays;
    }

    public void setPolicDays(int policDays) {
        this.policDays = policDays;
    }

    public String getPolicCompany() {
        return policCompany;
    }

    public void setPolicCompany(String policCompany) {
        this.policCompany = policCompany;
    }

    public String getMedcardId() {
        return medcardId;
    }

    public void setMedcardId(String medcardId) {
        this.medcardId = medcardId;
    }
}
