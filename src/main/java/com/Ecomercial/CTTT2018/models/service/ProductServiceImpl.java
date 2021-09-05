package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.VirtualProduct;
import com.Ecomercial.CTTT2018.models.repository.BrandRepository;
import com.Ecomercial.CTTT2018.models.repository.CompanyRepository;
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
    private BrandRepository brandRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){this.productRepository = productRepository;}


    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product>getPriceBetween(Long start,Long end)
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
        Product product;
        if(productForm.getIsPhysicalProduct())
        {
            PhysicalProduct physicalProduct = new PhysicalProduct();
            physicalProduct.setLength(productForm.getLength());
            physicalProduct.setWidth (productForm.getWidth() );
            physicalProduct.setHeight(productForm.getHeight());
            physicalProduct.setWeight(productForm.getWeight());
            product = physicalProduct;
        }
        else {
            VirtualProduct virtualProduct = new VirtualProduct();
            virtualProduct.setSerial(productForm.getSerial());
            product = virtualProduct;
        }

        //Common Attributes
        product.setBrand(brandRepository.findOneById(productForm.getBrandId()).get());
        product.setCompany(companyRepository.findOneById(productForm.getCompanyId()).get());
        product.setName(productForm.getName());
        product.setAveragePrice(productForm.getAveragePrice());
        product.setDateTime(new Date());

        return productRepository.save(product);
    }
}

