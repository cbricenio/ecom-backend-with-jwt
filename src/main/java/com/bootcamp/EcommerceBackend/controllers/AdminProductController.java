package com.bootcamp.EcommerceBackend.controllers;

import com.bootcamp.EcommerceBackend.entities.Product;
import com.bootcamp.EcommerceBackend.services.ProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/admin/")
public class AdminProductController {

    @Autowired
    private ProductServices productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Long id) {
        return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.CREATED);
    }

//    @PostMapping("/saveProduct")
//    public ResponseEntity<Product> addProduct (@RequestParam("file") MultipartFile file,
//                                               @RequestParam("product") String productJson){
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Product newProduct = objectMapper.readValue(productJson, Product.class);
//
//            // Save the image file and update the image field of the product
//            String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//            String filePath = "\\C:\\Users\\chino.bricenio_novar\\Practice\\ecommerce-practice\\src\\Images\\" + fileName; // Set your desired image directory path here
//            File imageFile = new File(filePath);
//            file.transferTo(imageFile);
//            newProduct.setImage(fileName);
//
//            Product addedProduct = productService.saveProduct(newProduct);
//            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }


}
