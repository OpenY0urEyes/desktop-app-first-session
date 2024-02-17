module ru.mail.desktopandroidapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires java.sql;

    opens ru.mail.desktopandroidapp to javafx.fxml;
    exports ru.mail.desktopandroidapp;
    exports ru.mail.desktopandroidapp.controllers;
    opens ru.mail.desktopandroidapp.controllers to javafx.fxml;
}