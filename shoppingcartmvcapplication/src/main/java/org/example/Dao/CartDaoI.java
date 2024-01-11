package org.example.Dao;

import org.example.model.Product;

import java.util.List;

public interface CartDaoI {
    List<Product> getProductsByUserId(int userId);
}
