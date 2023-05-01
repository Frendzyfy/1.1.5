package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Configuration configuration = new Configuration().addAnnotatedClass(User.class);
    private final SessionFactory sessionFactory = configuration.buildSessionFactory();
    private final Session session = sessionFactory.getCurrentSession();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        session.beginTransaction();
        session.remove(id);
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
