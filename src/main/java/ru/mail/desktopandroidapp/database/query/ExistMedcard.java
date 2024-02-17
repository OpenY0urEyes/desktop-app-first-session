package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.MedcardConst;
import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistMedcard {
    /**
     * @summary Проверка на существование медкарты с таким названием
     * @param name - Имя медкарты
     * @return true если существует, false если не существует
     */
    public boolean existsMedcard(String name) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler= new DbHendler();
        String select = "SELECT * FROM " +  MedcardConst.TABLE_NAME + " WHERE " +
                MedcardConst.NAME + "=?";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(select);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return false;
        }
        else {
            return true;
        }
    }
}
