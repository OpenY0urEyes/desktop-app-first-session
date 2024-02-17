package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.HospitalizationConst;
import ru.mail.desktopandroidapp.database.DbHendler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class AddHospitalization {
    /**
     * @summary Создание госпитализации в базу данных
     * @param patientId - id пациента
     * @param codeId - id кода от терапевта
     * @param date - дата проведения госпитализации
     * @param time - время проведения госпитализации
     *
     */

    public void addHospitalization(int patientId, int codeId, LocalDate date, String time) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        String insert = "INSERT INTO " + HospitalizationConst.TABLE_NAME + " (" +
                HospitalizationConst.PATIENT_ID + "," +
                HospitalizationConst.CODE_BY_TERAPEVT_ID + "," +
                HospitalizationConst.DATE + "," +
                HospitalizationConst.TIME + ") VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(insert);

        preparedStatement.setInt(1, patientId);
        preparedStatement.setInt(2, codeId);
        preparedStatement.setDate(3, Date.valueOf(date));
        preparedStatement.setTime(4, Time.valueOf(time));
        preparedStatement.executeUpdate();
    }


}
