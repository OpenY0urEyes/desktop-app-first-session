package ru.mail.desktopandroidapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.mail.desktopandroidapp.HelloApplication;

import java.io.IOException;

public class MainPageController {

    private Stage stage;
    private Scene mainScene;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }
    /**
     * @summary Переход на страницу с регистрацией пациента
     */
    @FXML
    public void regPatient() throws IOException {
        FXMLLoader fxmlLoaderMain = new FXMLLoader(HelloApplication.class.getResource("register-patient.fxml"));
        Scene scene = new Scene(fxmlLoaderMain.load(), 515, 446);
        RegisterPatientController registerPatientController = fxmlLoaderMain.getController();
        registerPatientController.setStage(stage);
        registerPatientController.setScene(mainScene);
        stage.setScene(scene);
    }

    /**
     * @summary Переход на страницу с госпитализацией
     */
    @FXML
    public void hospitalization() throws IOException {
        FXMLLoader fxmlLoaderHospit = new FXMLLoader(HelloApplication.class.getResource("hospitalization-page.fxml"));
        Scene scene = new Scene(fxmlLoaderHospit.load(), 515, 446);
        HospitalizationController hospitalizationController = fxmlLoaderHospit.getController();
        hospitalizationController.setStage(stage);
        hospitalizationController.setScene(mainScene);
        stage.setScene(scene);
    }
}
