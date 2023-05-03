package jm.task.core.jdbc.util;
import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;
public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connection");
        }
        return connection;
    }
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//    public void closeSessionFactory() {
//        sessionFactory.close();
//    }
    public static SessionFactory getCurrentSessionFromConfig() {
        getConnection();
        Configuration config = new Configuration()
                .setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/mydbtest")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password","root")
                .setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.current_session_context_class", "thread")
                .addAnnotatedClass(User.class);
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(config.getProperties()).build();

        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory;
    }
}
