package com.example.test_easy_bot.model.service;

import com.example.test_easy_bot.exception.ProductIsNotFoundException;
import com.example.test_easy_bot.infrastructure.ProductChangeRequest;
import com.example.test_easy_bot.infrastructure.ProductCreationRequest;
import com.example.test_easy_bot.model.entity.ProductEntity;
import com.example.test_easy_bot.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductCreationRequest request) {
        ProductEntity product = new ProductEntity();
        product.setType(request.getType().toString());
        product.setSerialNumber(request.getSerialNumber());
        product.setManufacturer(request.getManufacturer());
        product.setPrice(request.getPrice());
        product.setAmount(request.getAmount());
        product.setPcFormFactor(request.getPcFormFactor());
        product.setLaptopScreenSize(request.getLaptopScreenSize());
        product.setScreenSize(request.getScreenSize());
        product.setHardDiskSize(request.getHardDiskSize());
        productRepository.save(product);
    }

    public void changeProduct(ProductChangeRequest request) {
        ProductEntity product = getProductById(request.getId());
        product.setType(request.getType().toString());
        product.setSerialNumber(request.getSerialNumber());
        product.setManufacturer(request.getManufacturer());
        product.setPrice(request.getPrice());
        product.setAmount(request.getAmount());
        product.setPcFormFactor(request.getPcFormFactor());
        product.setLaptopScreenSize(request.getLaptopScreenSize());
        product.setScreenSize(request.getScreenSize());
        product.setHardDiskSize(request.getHardDiskSize());
        productRepository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(Integer id) {
        ProductEntity product = productRepository.findByProductId(id);
        if (product == null) {
            throw new ProductIsNotFoundException(id);
        }
        return product;
    }

    public boolean deleteProductById(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
