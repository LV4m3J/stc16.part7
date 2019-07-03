package ru.inno.stc14.dao;

import ru.inno.stc14.entity.User;

public interface UserDAO {

    User getUser(String login);
}
