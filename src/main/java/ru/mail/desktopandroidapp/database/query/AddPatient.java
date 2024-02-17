package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddPatient {
    /**
     * @summary Добавление пациента в базу данных
     * @param firtsname - Имя пациента
     * @param lastname - Фамилия пациента
     * @param middlename - Отчество пациента
     * @param passport - Паспорт пациента (серия номер)
     * @param polic - Полис
     * @param policEnd - Срок полиса
     * @param workPlace - Место работы
     * @param policCompany - Страховая компания
     * @param medcardId - id медкарты
     */
    public void addPatient(String firtsname,
                           String lastname,
                           String middlename,
                           String passport,
                           String polic,
                           int policEnd,
                           String workPlace,
                           String policCompany,
                           int medcardId) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler= new DbHendler();
        String insert = "INSERT INTO " + PatientConst.TABLE_NAME + " (" +
                PatientConst.FIRSTNAME + "," +
                PatientConst.LASTNAME + "," +
                PatientConst.MIDDLENAME + "," +
                PatientConst.PASSPROT + "," +
                PatientConst.WORK_PLACE + "," +
                PatientConst.POLIC + "," +
                PatientConst.POLIC_DAYS + "," +
                PatientConst.POLIC_COMPANY + "," +
                PatientConst.MEDCARD_ID + ") VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, firtsname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, middlename);
        preparedStatement.setString(4, passport);
        preparedStatement.setString(5, workPlace);
        preparedStatement.setString(6, polic);
        preparedStatement.setInt(7, policEnd);
        preparedStatement.setString(8, policCompany);
        preparedStatement.setInt(9, medcardId);
        preparedStatement.executeUpdate();
    }
}
