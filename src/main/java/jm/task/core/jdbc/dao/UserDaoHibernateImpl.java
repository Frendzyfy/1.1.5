package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT primary key NOT NULL, name VARCHAR(45) NOT NULL, lastname VARCHAR(45) NOT NULL, age INT NOT NULL)";
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void dropUsersTable() {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS users";
            Query query = session.createNativeQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = new User(name,lastName,age);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<User> list = session.createQuery("FROM User").getResultList();
            return list;
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void cleanUsersTable() {
        Session session1 = sessionFactory.getCurrentSession();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String hql = "DELETE User";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().rollback();
            }
            throw e;
        }
    }
}
