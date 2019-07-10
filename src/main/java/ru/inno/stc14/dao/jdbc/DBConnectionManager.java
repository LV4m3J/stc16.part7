package ru.inno.stc14.dao.jdbc;

import ru.inno.stc14.dao.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager implements ConnectionManager {
    /**
     * Singleton - для соединения с БД
     */
    private static Connection connection = null;

    private DBConnectionManager() {
    }

    public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
        if(connection == null) {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbURL, user, pwd);
        }

    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}
