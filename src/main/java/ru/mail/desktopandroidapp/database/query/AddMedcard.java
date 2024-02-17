package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.MedcardConst;
import ru.mail.desktopandroidapp.constants.PatientConst;
import ru.mail.desktopandroidapp.database.DbHendler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMedcard {

    /**
     * @summary Создание медкарты в базу данных
     * @param name - название медкарты
     * @return возвращает id созданной медкарты
     */
    public int addMedcard(String name) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler= new DbHendler();
        String insert = "INSERT INTO " + MedcardConst.TABLE_NAME + " (" +
                MedcardConst.NAME + ") VALUES (?)";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        String select = "SELECT * FROM " + MedcardConst.TABLE_NAME + " WHERE " + MedcardConst.NAME + "=?";
        PreparedStatement preparedStatement2 = dbHendler.getConnection().prepareStatement(select);
        preparedStatement2.setString(1, name);
        ResultSet resultSet = preparedStatement2.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(MedcardConst.ID);
        }
        else {
            return 0;
        }
    }

}
