package ru.mail.desktopandroidapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.mail.desktopandroidapp.HelloApplication;
import ru.mail.desktopandroidapp.database.query.Auth;
import ru.mail.desktopandroidapp.models.Doctor;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {


    @FXML
    private TextField firstname_text;
    @FXML
    private TextField lastname_text;
    @FXML
    private TextField password_text;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * @summary Вход в аккаунт
     */
    @FXML
    public void LogInAccount() throws SQLException, ClassNotFoundException, IOException {
        Auth auth = new Auth();
        Doctor doctor = auth.getDoctor(firstname_text.getText(), lastname_text.getText(), password_text.getText());
        if (doctor != null){
            System.out.println(doctor.getDoctor_type_id());
            FXMLLoader fxmlLoaderMain = new FXMLLoader(HelloApplication.class.getResource("main-page.fxml"));
            Scene scene = new Scene(fxmlLoaderMain.load(), 515, 446);
            MainPageController mainPageController= fxmlLoaderMain.getController();
            mainPageController.setMainScene(scene);
            mainPageController.setStage(stage);
            stage.setScene(scene);
        }
    }
}