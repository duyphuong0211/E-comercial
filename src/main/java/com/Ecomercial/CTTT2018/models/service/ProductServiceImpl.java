package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){this.productRepository = productRepository;}


    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> getPriceBetween(double start,double end)
    {
        return productRepository.findByAveragePriceBetween(start,end);
    }

    @Override
    public Collection<Product>getAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(AddProductForm productForm) {
        //TODO Add Virtual/Physical Product

        Product product = new PhysicalProduct();
        product.setBrand(productForm.getBrand());
        product.setName(productForm.getName());
        product.setAveragePrice(productForm.getAveragePrice());
        product.setDateTime(new Date());
        return productRepository.save(product);
    }
}
