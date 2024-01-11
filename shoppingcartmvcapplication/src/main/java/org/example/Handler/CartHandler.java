package org.example.Handler;

import org.example.Dao.CartDao;
import org.example.Dao.ProductDao;
import org.example.Dao.UserDao;
import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.UserCartMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartHandler {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

//    public void addProductToUserCart(Cart cart) {
//        User user = userDao.findByName(cart.getUser().getName());
//        Product product = productDao.findByName(cart.getProduct().getName());
//
//        if (user == null || product == null) {
//            throw new RuntimeException("User or Product not found.");
//        }
//
//        cart.setUser(user);
//        cart.setProduct(product);
//        cartDao.addProductToCart(cart);
//    }
//
    public String addCartToUser(int id) {
        try {
            User user = userDao.findById(id);
            if (user == null) {
                throw new IllegalArgumentException("User not found with ID: " + id);
            }

            Cart cart = new Cart();
            cart.setUser(user);

            user.setCart(cart);

            userDao.updateUser(user);

            return "Cart added successfully!";
        } catch (Exception e) {
            throw new RuntimeException("Error adding cart to user", e);
        }
    }
//    public Cart getCartForUser(int id){
//        User user = userDao.findById(id);
//        Cart cart = user.getCart();
//        return cart;
//    }

//    public List<Product> addProductToUserCart(int id, Product product) {
//        Cart cart = getCartForUser(id);
//
//
//        product.setCart(cart);
//
//        List<Product> products = cart.getProducts();
//        boolean productExists = false;
//
//        for (Product existingProduct : products) {
//            if (existingProduct.getId() == product.getId()) {
//                existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
//                cart.setQuantity(cart.getQuantity() + product.getQuantity());
//                productExists = true;
//                break;
//            }
//        }
//
//        if (!productExists) {
//            products.add(product);
//           cart.setQuantity(cart.getQuantity() + product.getQuantity());
//        }
//
//        cart.setProducts(products);
//        cartDao.updateCart(cart);
//        productDao.decreaseProductQuantityInShop(product.getId(), product.getQuantity());
//
//        return products;
//    }

    public String addProductToCart(int userId, int productId, int quantity) {
        User user = userDao.findById(userId);
        Product product = productDao.findById(productId);

        if (user == null || product == null) {
            return "User or Product not found.";
        }

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        UserCartMapping cartItem = new UserCartMapping();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cart.getCartItems().add(cartItem);

        cartDao.addProductToCart(cart);
        return "Product added to cart successfully!";
    }

    public List<Product> getProductsInCart(int userId) {
        return cartDao.getProductsByUserId(userId);
    }

}