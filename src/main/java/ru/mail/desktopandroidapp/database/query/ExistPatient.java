package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistPatient {
    /**
     * @summary Проверка на существование пациента
     * @param firtsname - Имя пациента
     * @param lastname - фамилия пациента
     * @param middlename - отчество пациента
     * @param passport - паспорт пациента
     * @param polic - полис пациента
     * @return true если существует, false если не существует
     */
    public boolean existsPatient(String firtsname, String lastname, String middlename, String passport, String polic) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler= new DbHendler();
        String select = "SELECT * FROM " + PatientConst.TABLE_NAME + " WHERE " +
                PatientConst.FIRSTNAME + "=? AND " +
                PatientConst.LASTNAME + "=? AND " +
                PatientConst.MIDDLENAME + "=? OR " +
                PatientConst.PASSPROT + "=? OR " +
                PatientConst.POLIC + "=?";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(select);
        preparedStatement.setString(1, firtsname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, middlename);
        preparedStatement.setString(4, passport);
        preparedStatement.setString(5, polic);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return false;
        }
        else {
            return true;
        }
    }
}
