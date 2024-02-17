package ru.mail.desktopandroidapp.database.query;

import ru.mail.desktopandroidapp.constants.CodeByTerapevtConst;
import ru.mail.desktopandroidapp.database.DbHendler;
import ru.mail.desktopandroidapp.models.Code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewInfoCode {

    /**
     * @summary Информация из кода от терапевта из базы данных
     * @param name - код
     * @return объект code
     */

    public Code getInfoCode(String name) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        String select = "SELECT * FROM " + CodeByTerapevtConst.TABLE_NAME + " WHERE " + CodeByTerapevtConst.NAME + "=? ";
        PreparedStatement preparedStatement = dbHendler.getConnection().prepareStatement(select);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Code foundedCode = new Code();
            foundedCode.setAddDescription(resultSet.getString(CodeByTerapevtConst.ADD_DESC));
            foundedCode.setDiagnozez(resultSet.getString(CodeByTerapevtConst.DIAGNOZEZ));
            foundedCode.setName(resultSet.getString(CodeByTerapevtConst.NAME));
            foundedCode.setOtdelenie(resultSet.getString(CodeByTerapevtConst.OTDELENIE));
            foundedCode.setUslovie(resultSet.getString(CodeByTerapevtConst.USLOVIE));
            foundedCode.setSrokHospit(resultSet.getInt(CodeByTerapevtConst.SROK_HOSPIT));
            foundedCode.setCelHospit(resultSet.getString(CodeByTerapevtConst.CEL_HOSPIT));
            foundedCode.setId(resultSet.getInt(CodeByTerapevtConst.ID));
            return foundedCode;

        }
        return null;
    }
}
