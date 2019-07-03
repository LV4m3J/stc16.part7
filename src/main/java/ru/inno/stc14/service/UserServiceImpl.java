package ru.inno.stc14.service;

import ru.inno.stc14.dao.jdbc.UserDAOimpl;
import java.sql.Connection;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    /**
     * Проверка пользователя
     */

    private static Logger logger = Logger.getLogger(UserDAOimpl.class.getName());
    private final UserDAOimpl userDao;

    public UserServiceImpl(Connection connection) {
        this.userDao = new UserDAOimpl(connection);
    }

    /**
     *
     * @param login логин из формы
     * @param password пароль из формы
     * @return булево значения результата проверки
     */

    @Override
    public boolean checkUser(String login, Integer password) {
       Boolean result;

       if(login.equals(userDao.getUser(login).getLogin()) & password.equals(userDao.getUser(login).getPassword())){
           result = true;
       } else {
           result = false;
       }

       logger.warning(result.toString());
       return result;
    }
}
