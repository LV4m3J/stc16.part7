package ru.inno.stc14.dao.jdbc;

import ru.inno.stc14.dao.UserDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UserDAOimpl implements UserDAO {
    private static Logger logger = Logger.getLogger(UserDAOimpl.class.getName());
    private final Connection connection;
    private String login;
    private ResultSet resultSet;

    private String SELECT_USER_FROM_DB = "select * from STUDENTS.PUBLIC.USERS where login = " + login + ";";

    public UserDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Map<String, String> getUser(String login) {
        Map<String, String> result = new HashMap<>();
        this.login = login;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_USER_FROM_DB);
            resultSet.next();
            result.put(resultSet.getString(2),resultSet.getString(3)); // org.h2.jdbc.JdbcSQLNonTransientException: No data is available [2000-199]
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
