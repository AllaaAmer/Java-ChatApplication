/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandlerpkg;

import oracle.jdbc.driver.*;
import java.sql.*;

/**
 *
 * @author adelz
 */
public class DBHandler {

    public DBHandler() {
         try {
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "dola", "123"); //Change your name and pass here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public boolean closeConnection() {
        try {
            connection.close();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
