package org.example.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.Dao.ProductDao;
import org.example.Handler.ProductHandler;
import org.example.model.Product;
import org.example.service.ShopingcartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ShoppingcartController {

    private static final Logger LOGGER = LogManager.getLogger(ShoppingcartController.class);

   @Autowired
   private ProductHandler productHandler;

   @Autowired
   private ShopingcartService shopingcartService;

    @RequestMapping("/")
    public String indexPage() {
        LOGGER.info("Accessed indexPage endpoint");
        return "index";
    }

    @GetMapping("/addproduct")
    public String addproduct(){
        LOGGER.info("Accessed addproduct endpoint");
        return "addproduct";
    }

    @PostMapping(value = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productHandler.addOrUpdateProduct(product);
        return ResponseEntity.ok("Product Added successfully");
    }


    @GetMapping("/dashboard")
    public String getproducts(){
        LOGGER.info("Accessed dashboard endpoint");
        return "dashboard";
    }


    @GetMapping(value = "/dashboard/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> fetchProductsDetails(@RequestHeader(name = "category",required = true) String category) {
        LOGGER.debug("Fetching products for category");
        List<Product> products = new ArrayList<>();
        if (category != null) {
            products = shopingcartService.getProductByCategory(category);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/removeproduct")
    public String removeProducts(){
        return "removeproduct";
    }


    @GetMapping("/removeproduct/{productName}")
    public ResponseEntity<String> removeProductByName(@PathVariable String productName) {
        productHandler.removeProduct(productName);
        return ResponseEntity.ok("Product removed successfully");
    }
}
