package org.example.db;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbQueries {

    //TODO - fetch category wise data
    public static String GET_PRODUCT_BY_CATEGORY = "from Product p where p.category = :category";


    public static final String GET_ALL_PRODUCTS = "from Product";

   // public static final String GET_PRODUCT_BY_ID = "form Cart where product.id =:id";


//    public Product findProductByName(Session session, String name) {
//        Query<Product> query = session.createQuery("FROM Product WHERE name = :name", Product.class);
//        query.setParameter("name", name);
//        return query.uniqueResult();
//    }
    public static final  String FIND_PRODUCT_BY_NAME = "FROM Product WHERE name = :name";
}
