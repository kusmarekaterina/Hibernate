package dao;

import model.User;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;


import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User add(User user) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
        return user;
    }

    @Override
    public User getById(int id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(User.class,id);
        }
    }

    @Override
    public List getAllUser() {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM User").list();
        }
    }

    @Override
    public User updateUser(User user) {
        User update;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            update = (User) session.merge(user);
            transaction.commit();
        }
        return update;
    }

    @Override
    public void deleteUser(User user) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User updateUser = session.find(User.class, user.getId());
            Role associatedRole = session.find(Role.class, role.getId());
            updateUser.getRoles().add(associatedRole);
            transaction.commit();
        }
    }
}
