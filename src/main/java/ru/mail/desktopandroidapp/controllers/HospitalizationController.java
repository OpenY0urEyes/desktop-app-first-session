package ru.mail.desktopandroidapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.mail.desktopandroidapp.HelloApplication;
import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.query.AddHospitalization;
import ru.mail.desktopandroidapp.database.query.ViewInfoCode;
import ru.mail.desktopandroidapp.database.query.ViewInfoPatient;
import ru.mail.desktopandroidapp.models.Code;
import ru.mail.desktopandroidapp.models.Patient;

import java.io.IOException;
import java.sql.SQLException;
/*
 * Контроллер страницы с госпитализацией
 * */

public class HospitalizationController {
    @FXML
    private TextField fisrtname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField middlename;
    @FXML
    private TextField passport;
    @FXML
    private TextField polic;
    @FXML
    private TextField policCompany;

    @FXML
    private TextField workPlace;

    @FXML
    private TextField code_text;

    @FXML
    private TextField time;

    @FXML
    private DatePicker date;

    @FXML
    private Label diagnozez;
    @FXML
    private Label celHospitality;
    @FXML
    private Label otdelenie;
    @FXML
    private Label uslovie;
    @FXML
    private Label srokHospitality;
    @FXML
    private Label addDescription;


    private Stage stage;

    private Scene scene;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    /**
     * @summary Создание госпитализации
     */
    @FXML
    public void addHospitalization() throws SQLException, ClassNotFoundException {
        ViewInfoCode viewInfoCode = new ViewInfoCode();
        ViewInfoPatient viewInfoPatient = new ViewInfoPatient();
        AddHospitalization addHospitalization = new AddHospitalization();

        Code code = viewInfoCode.getInfoCode(code_text.getText());
        Patient patient = viewInfoPatient.getPatient(fisrtname.getText(), lastname.getText(), middlename.getText(), passport.getText(), workPlace.getText(), polic.getText(), policCompany.getText());
        addHospitalization.addHospitalization(patient.getPatientId(), code.getId(), date.getValue(), time.getText());
    }
    /**
     * @summary Просмотр инфомрации о госпитализации по коду
     */
    @FXML
    public void viewInfoCode() throws SQLException, ClassNotFoundException {
        ViewInfoCode viewInfoCode = new ViewInfoCode();
        Code code = viewInfoCode.getInfoCode(code_text.getText());
        diagnozez.setText(code.getDiagnozez());
        celHospitality.setText(code.getCelHospit());
        otdelenie.setText(code.getOtdelenie());
        uslovie.setText(code.getUslovie());
        srokHospitality.setText(String.valueOf(code.getSrokHospit()));
        addDescription.setText(code.getAddDescription());
    }

    /**
     * @summary Выход на main страницу
     */
    @FXML
    public void backToMain() throws IOException {
        stage.setScene(scene);
    }



}
