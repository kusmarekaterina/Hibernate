package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import javax.management.relation.Role;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public Role add(Role role) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        }
        return role;
    }

    @Override
    public Role getById(int id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(Role.class, id);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Role").list();
        }
    }

    @Override
    public void deleteRole(Role role) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
    }
}
