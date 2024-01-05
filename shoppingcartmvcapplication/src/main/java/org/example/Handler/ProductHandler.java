package org.example.Handler;

import org.example.Dao.ProductDao;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductHandler {


    @Autowired

    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

//    public String addProduct(Product product) {
//        Product existingProduct = productDao.findProductByName(product.getName());
//        if (existingProduct != null) {
//        existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
//    }
//        return "Product added scuuessfully !";
//    }

    public void addOrUpdateProduct(Product product) {
        Product existingProduct = productDao.findProductByName(product.getName());
        if (existingProduct != null) {
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
            productDao.updateProductByName(existingProduct);
        } else {
            productDao.saveProduct(product);
        }
    }
    public void removeProduct(String productName) {
        Product product = productDao.findProductByName(productName);
        if (product != null) {
            productDao.removeProduct(product);
        } else {
            throw new RuntimeException("Product not found with name: " + productName);
        }
    }
    public Product getProductById(int id) {
        return productDao.findById(id);
    }
}
