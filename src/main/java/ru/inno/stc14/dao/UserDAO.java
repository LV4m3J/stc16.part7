package ru.inno.stc14.dao;

import java.util.Map;

public interface UserDAO {

    Map<String, String> getUser(String login);
}
