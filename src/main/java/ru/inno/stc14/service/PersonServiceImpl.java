package ru.inno.stc14.service;

import ru.inno.stc14.dao.PersonDAO;
import ru.inno.stc14.dao.jdbc.PersonDAOImpl;
import ru.inno.stc14.entity.Person;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {
    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final PersonDAO personDAO;

    public PersonServiceImpl(Connection con) {
        personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(String name, String birth, String email, String phoneNum) {
        Person person = new Person();
        person.setName(name);

        //Date date = safeParseDate(birth);
        person.setBirthDate(birth);

        person.setEmail(email);
        person.setPhoneNum(phoneNum);

        return personDAO.addPerson(person);
    }

    /*private Date safeParseDate(String birthStr) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(birthStr);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Date parsing error", e);
            throw new RuntimeException(e);
        }
    }*/

}
