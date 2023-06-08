package com.bootcamp.EcommerceBackend.services;

import com.bootcamp.EcommerceBackend.entities.Product;

import java.util.List;

public interface ProductServices {

    public Product saveProduct(Product product);

    public List<Product> getAllProduct();

    public Product getProductById(Long id);

    public String deleteProduct(Long id);

    public Product editProduct(Product product,Long id);

}
