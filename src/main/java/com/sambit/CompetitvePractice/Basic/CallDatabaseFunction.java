package com.sambit.CompetitvePractice.Basic;

import com.sambit.CustomException.CustomException;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 12-Mar-2024 : 9:37 AM
 */

public class CallDatabaseFunction {

    public static Map<String, Object> getScheme(Map<String, Object> request) {
        Map<String, Object> schemeMap = new LinkedHashMap<>();
        try (Connection connection = new CallDatabaseFunction().establishConnection();
             CallableStatement callableStatement = connection.prepareCall("{ ? = call USF_GET_SCHEMEID_TMS(?) }")) {

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.setString(2, request.get("searchInput").toString());

            callableStatement.execute();

            ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

            while (resultSet.next()) {
                schemeMap.put("schemeId", resultSet.getInt("SCHEMEID"));
                schemeMap.put("schemeCategoryId", resultSet.getInt("SCHEMECATEGORYID"));
                schemeMap.put("searchType", resultSet.getString("SEARCHTYPE"));
            }

            closeResources(resultSet, callableStatement, connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new CustomException(e.getMessage());
        }
        return schemeMap;
    }

    private Connection establishConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "oracle");
    }

    private static void closeResources(ResultSet resultSet, CallableStatement callableStatement, Connection connection) throws SQLException {
        if (resultSet != null)
            resultSet.close();
        if (callableStatement != null)
            callableStatement.close();
        if (connection != null)
            connection.close();
    }
}
