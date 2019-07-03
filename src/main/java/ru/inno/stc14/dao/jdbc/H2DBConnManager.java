package ru.inno.stc14.dao.jdbc;

import ru.inno.stc14.dao.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DBConnManager implements ConnectionManager {
    private Connection connection;

    public H2DBConnManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection(dbURL, user, pwd);
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
