package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;
import ru.mail.desktopandroidapp.models.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewInfoPatient {
    /**
     * @summary информаця о пациенте
     * @param firstname - Имя пациента
     * @param lastname - фамилия пациента
     * @param middlename - отчество пациента
     * @param passport - паспорт пациента
     * @param polic - полис пациента
     * @param workPlace - место работы пациента
     * @param policCompany - страховая компания
     * @return объект Patient
     */
    public Patient getPatient(String firstname, String lastname, String middlename, String passport, String workPlace, String polic, String policCompany) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        String select = "SELECT * FROM " + PatientConst.TABLE_NAME + " WHERE " + PatientConst.FIRSTNAME + "=? AND " +
                PatientConst.LASTNAME + "=? AND " +
                PatientConst.MIDDLENAME + "=? AND " +
                PatientConst.PASSPROT + "=? AND " +
                PatientConst.WORK_PLACE + "=? AND " +
                PatientConst.POLIC + "=? AND " +
                PatientConst.POLIC_COMPANY + "=?";

        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(select);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, middlename);
        preparedStatement.setString(4, passport);
        preparedStatement.setString(5, workPlace);
        preparedStatement.setString(6, polic);
        preparedStatement.setString(7, policCompany);
        ResultSet resultSet =  preparedStatement.executeQuery();

        if (resultSet.next()){
            Patient patient = new Patient();
            patient.setFirstname(resultSet.getString(PatientConst.FIRSTNAME));
            patient.setLastname(resultSet.getString(PatientConst.LASTNAME));
            patient.setMiddlename(resultSet.getString(PatientConst.MIDDLENAME));
            patient.setPatientId(resultSet.getInt(PatientConst.ID));
            patient.setPassport(resultSet.getString(PatientConst.PASSPROT));
            patient.setPolic(resultSet.getString(PatientConst.POLIC));
            patient.setPolicCompany(resultSet.getString(PatientConst.POLIC_COMPANY));
            patient.setWork_place(resultSet.getString(PatientConst.WORK_PLACE));
            patient.setMedcardId(resultSet.getString(PatientConst.MEDCARD_ID));
            patient.setPolicDays(resultSet.getInt(PatientConst.POLIC_DAYS));
            return  patient;
        }
        return null;
    }
}
