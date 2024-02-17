package ru.mail.desktopandroidapp.models;

public class Code {

    private int id;
    private String name;
    private String diagnozez;
    private String celHospit;
    private String otdelenie;
    private String uslovie;
    private int srokHospit;
    private String addDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiagnozez() {
        return diagnozez;
    }

    public void setDiagnozez(String diagnozez) {
        this.diagnozez = diagnozez;
    }

    public String getCelHospit() {
        return celHospit;
    }

    public void setCelHospit(String celHospit) {
        this.celHospit = celHospit;
    }

    public String getOtdelenie() {
        return otdelenie;
    }

    public void setOtdelenie(String otdelenie) {
        this.otdelenie = otdelenie;
    }

    public String getUslovie() {
        return uslovie;
    }

    public void setUslovie(String uslovie) {
        this.uslovie = uslovie;
    }

    public int getSrokHospit() {
        return srokHospit;
    }

    public void setSrokHospit(int srokHospit) {
        this.srokHospit = srokHospit;
    }

    public String getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }
}
