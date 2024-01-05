package org.example.Handler;

import org.example.Dao.CartDao;
import org.example.Dao.ProductDao;
import org.example.Dao.UserDao;
import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartHandler {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

//    public void addProductToUserCart(Cart cart) {
//        User user = userDao.findById(cart.getUser().getUserId());
//        Product product = productDao.findById(cart.getProduct().getId());
//
//        if (user == null || product == null) {
//            throw new RuntimeException("User or Product not found.");
//        }
//
//        cart.setUser(user);
//        cart.setProduct(product);
//        cartDao.addProductToCart(cart);
//    }
}