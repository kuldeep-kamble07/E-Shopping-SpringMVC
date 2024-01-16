package org.example.controller;

import org.example.Dao.CartDao;
import org.example.Dao.ProductDao;
import org.example.Dao.UserDao;
import org.example.Handler.CartHandler;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartContoller {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartHandler cartHandler;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/showCart")
    public String showCart() {
        return "mycart";
    }



    @PostMapping(value = "/adduserToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestHeader(value = "id") int id) {
        try {
            return ResponseEntity.ok(cartHandler.addCartToUser(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding cart to user: " + e.getMessage());
        }
    }


    @PostMapping(value = "/addtocart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addingProductToCart(@RequestHeader(value = "userId") int userId,
                                                      @RequestHeader(value = "productId") int productId,
                                                      @RequestHeader(value = "quantity") int quantity) {
        try {
         String response = cartHandler.addProductToCart(userId, productId, quantity);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding product to cart: " + e.getMessage());
        }
    }

    @GetMapping(value = "/cart/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> fetchProductsInCart(@RequestHeader("userId") int userId) {
        List<Product> products = cartHandler.getProductsInCart(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}