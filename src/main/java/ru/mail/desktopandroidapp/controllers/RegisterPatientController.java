package ru.mail.desktopandroidapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.mail.desktopandroidapp.HelloApplication;
import ru.mail.desktopandroidapp.database.query.AddMedcard;
import ru.mail.desktopandroidapp.database.query.AddPatient;
import ru.mail.desktopandroidapp.database.query.ExistMedcard;
import ru.mail.desktopandroidapp.database.query.ExistPatient;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterPatientController {

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastame;
    @FXML
    private TextField middlename;
    @FXML
    private TextField workPlace;
    @FXML
    private TextField passport;
    @FXML
    private TextField polic;
    @FXML
    private TextField policEnd;
    @FXML
    private TextField policCompany;
    @FXML
    private TextField medcard;

    private Stage stage;
    private Scene scene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * @summary Добавление пациента в базу данных
     */

    public void addPatient() throws SQLException, ClassNotFoundException {
        String firstname_t = firstname.getText();
        String lastname_t = lastame.getText();
        String middlename_t = middlename.getText();
        String passport_t = passport.getText();
        String workPlace_t = workPlace.getText();
        String polic_t = polic.getText();
        int policEnd_t = Integer.parseInt(policEnd.getText());
        String policCompany_t = policCompany.getText();
        String medcard_t = medcard.getText();

        ExistPatient existPatient = new ExistPatient();
        ExistMedcard existMedcard = new ExistMedcard();
        AddPatient addPatient = new AddPatient();
        AddMedcard addMedcard = new AddMedcard();

        if (existPatient.existsPatient(firstname_t,lastname_t,middlename_t,passport_t,polic_t) || existMedcard.existsMedcard(medcard_t)){
            int id = addMedcard.addMedcard(medcard_t);
            addPatient.addPatient(firstname_t,lastname_t,middlename_t,passport_t,polic_t,policEnd_t,workPlace_t,policCompany_t, id);
        }
    }
    /**
     * @summary Выход на main страницу
     */
    @FXML
    public void backToMain() throws IOException {
        stage.setScene(scene);
    }
}
