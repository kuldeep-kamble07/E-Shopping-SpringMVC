package org.example.controller;

import org.example.Dao.CartDao;
import org.example.Dao.ProductDao;
import org.example.Dao.UserDao;
import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartContoller {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/showCart")
    public String showCart() {
        return "mycart";
    }

//    @Autowired
//    private CartDao cartDao;

//    @PostMapping(value = "/add", consumes = "application/json")
//    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
//        cartDao.addProductToCart(cart);
//        return ResponseEntity.ok(cart);
//    }



//    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
//       // User user = userDao.findById(cart.getUser().getUserId());
//        Product product = productDao.findById(cart.getProduct().getId());
//
//        if (product == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//     //   cart.setUser(user);
//        cart.setProduct(product);
//        cartDao.addProductToCart(cart);
//        return ResponseEntity.ok(cart);
//    }
}
