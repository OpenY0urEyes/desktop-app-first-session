package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.DoctorConst;
import ru.mail.desktopandroidapp.database.DbHendler;
import ru.mail.desktopandroidapp.models.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {

    /**
     * @summary Вход в аккаунт доктора
     * @param fistname - Имя Доктора
     * @param lastname - Фамилия доктора
     * @param password - Пароль доктора
     * @return объект Doctor
     */

    public Doctor getDoctor(String fistname, String lastname, String password) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        String select = "SELECT * FROM " + DoctorConst.TABLE_NAME + " WHERE " + DoctorConst.FIRSTNAME + "=? AND " +
                DoctorConst.LASTNAME + "=? AND " +
                DoctorConst.PASSWORD + "=?";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(select);
        preparedStatement.setString(1, fistname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Doctor foundedDoctor = new Doctor();
            foundedDoctor.setFirstname(resultSet.getString(DoctorConst.FIRSTNAME));
            foundedDoctor.setLastname(resultSet.getString(DoctorConst.LASTNAME));
            foundedDoctor.setMiddlename(resultSet.getString(DoctorConst.MIDDLENAME));
            foundedDoctor.setPassword(resultSet.getString(DoctorConst.PASSWORD));
            foundedDoctor.setDoctor_type_id(resultSet.getInt(DoctorConst.TYPE_ID));
            return foundedDoctor;
        }
        return null;
    }
}
