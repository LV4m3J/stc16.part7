package ru.inno.stc14.dao.jdbc;

import ru.inno.stc14.dao.UserDAO;
import ru.inno.stc14.entity.USER_ROLE;
import ru.inno.stc14.entity.User;

import java.sql.*;
import java.util.logging.Logger;

public class UserDAOimpl implements UserDAO {
    /**
     * ДАО слой
     */

    private static Logger logger = Logger.getLogger(UserDAOimpl.class.getName());
    private final Connection connection;
    private String login;
    private User user;

    private String SELECT_USER_FROM_DB = "select * from stc16.stc16servlets.users where login = ?";

    public UserDAOimpl(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param login - лоиг на провеку в бд
     * @return возвращает объект типа Юзер
     */

    @Override
    public User getUser(String login) {
        this.login = login;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_FROM_DB);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                //user.setUserRole(resultSet.getObject(4));
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
