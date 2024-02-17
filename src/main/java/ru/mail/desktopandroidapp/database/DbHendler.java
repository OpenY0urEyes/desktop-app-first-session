package ru.mail.desktopandroidapp.database;

import ru.mail.desktopandroidapp.config.DatabaseConfig;

import java.sql.*;

public class DbHendler extends DatabaseConfig {

    Connection connection;
    /**
     * @summary Подключение к базе данных
     * @return connection
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String stringConnection = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        connection = DriverManager.getConnection(stringConnection, dbUser, dbPass);
        return connection;
    }

}
