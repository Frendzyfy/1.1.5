package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        UserService us = new UserServiceImpl();
        try {
            us.dropUsersTable();
            us.createUsersTable();
            us.saveUser("testName", "testLastName", (byte) 23);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
