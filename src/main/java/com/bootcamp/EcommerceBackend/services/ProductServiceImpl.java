package com.bootcamp.EcommerceBackend.services;

import com.bootcamp.EcommerceBackend.entities.Product;
import com.bootcamp.EcommerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductServices{

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {

        return repository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));

    }

    @Override
    public String deleteProduct(Long id) {
        Product product = repository.findById(id).get();

        if (product != null) {
            repository.delete(product);
            return "Product Delete Sucessfully";
        }

        return "Something wrong on server";
    }

    @Override
    public Product editProduct(Product p, Long id) {

        Product oldProduct = repository.findById(id).get();

        oldProduct.setProductName(p.getProductName());
        oldProduct.setDescription(p.getDescription());
        oldProduct.setPrice(p.getPrice());
        oldProduct.setCategory(p.getCategory());
        oldProduct.setQuantity(p.getQuantity());
        oldProduct.setImage(p.getImage());

        return repository.save(oldProduct);
    }

}
