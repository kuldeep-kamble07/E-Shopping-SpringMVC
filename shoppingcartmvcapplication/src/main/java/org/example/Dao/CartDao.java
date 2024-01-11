package org.example.Dao;

import org.example.db.DbQueries;
import org.example.model.Cart;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDao implements CartDaoI{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private DbQueries dbQueries;
    public void addProductToCart(Cart cart) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cart);
        session.getTransaction().commit();
        session.close();
    }

    public void updateCart(Cart cart) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(cart);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error updating cart", e);
        }
    }

    @Override
    public List<Product> getProductsByUserId(int userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Product> query = session.createQuery(dbQueries.GET_PRODUCTS_BY_USER_ID, Product.class);
            query.setParameter("userId", userId);
            List<Product> products = query.getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

}
