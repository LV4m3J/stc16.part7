package ru.inno.stc14.service;

import ru.inno.stc14.dao.jdbc.UserDAOimpl;

import java.sql.Connection;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDAOimpl userDao;

    public UserServiceImpl(Connection connection) {
        this.userDao = new UserDAOimpl(connection);
    }

    @Override
    public boolean checkUser(String login, String password) {
        Map<String,String> daoUser = userDao.getUser(login);
        if(daoUser.containsKey(login) & daoUser.containsValue(password)) {
            return true;
        } else {
            return false;
        }
    }
}
