package org.example.Dao;

import org.example.model.Cart;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void addProductToCart(Cart cart) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cart);
        session.getTransaction().commit();
        session.close();
    }
}
