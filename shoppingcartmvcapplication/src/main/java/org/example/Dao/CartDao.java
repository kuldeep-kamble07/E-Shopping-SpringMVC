package org.example.Dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.db.DbQueries;
import org.example.model.UserCartMapping;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDao implements CartDaoI{


    private static final Logger LOGGER = LogManager.getLogger(CartDao.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private DbQueries dbQueries;
    public void addProductToCart(UserCartMapping userCartMapping) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userCartMapping);
        session.getTransaction().commit();
        session.close();
    }

    public void updateCart(UserCartMapping userCartMapping) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(userCartMapping);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error updating cart", e);
        }
    }

    @Override
    public List<Product> getProductsByUserId(int userId) {
        try {
            LOGGER.info("start::CartDao::getProductsByUserId::");

            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                Query<UserCartMapping> query = session.createQuery(DbQueries.GET_PRODUCTS_BY_USER_ID, UserCartMapping.class);
                query.setParameter("userId", userId);

                List<UserCartMapping> cartMappings = query.getResultList();

                session.getTransaction().commit();

                List<Product> productsInCart = new ArrayList<>();
                for (UserCartMapping cartMapping : cartMappings) {
                    productsInCart.add(cartMapping.getProduct());
                }

                return productsInCart;
            }
        } catch (Exception e) {
            LOGGER.error("Error fetching products in cart", e);
            throw new RuntimeException("Error fetching products in cart", e);
        }
    }
}
