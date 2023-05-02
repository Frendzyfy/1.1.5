package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        us.dropUsersTable();
        us.createUsersTable();
        us.saveUser("Kolya", "testLastName", (byte) 23);
        us.removeUserById(1L);
//        us.dropUsersTable();
//        us.createUsersTable();
//        us.removeUserById(1);
//        us.removeUserById(2);
//        try {
//            us.createUsersTable();
//            us.saveUser("Dmitry", "Makarov", (byte) 23);
//            us.saveUser("Andrew", "Matthews", (byte) 25);
//            us.saveUser("Tom", "Hardy", (byte) 27);
//            us.saveUser("John", "Yuk", (byte) 43);
//            List<User> list = us.getAllUsers();
//            list.stream().forEach(x -> System.out.println(x.toString()));
//            us.cleanUsersTable();
//            us.dropUsersTable();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
