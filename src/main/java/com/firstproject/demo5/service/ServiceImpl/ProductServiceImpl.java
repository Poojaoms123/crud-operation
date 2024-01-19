package com.firstproject.demo5.service.ServiceImpl;

import com.firstproject.demo5.model.Response.pageDTO;
import com.firstproject.demo5.model.SaveRequest.SaveProductRequest;
import com.firstproject.demo5.model.product;
import com.firstproject.demo5.repository.ProductRepository;
import com.firstproject.demo5.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String saveOrUpdateProduct(SaveProductRequest saveProductRequest) {
        if (productRepository.existsById(saveProductRequest.getProductId())) {
            product product = productRepository.findById(saveProductRequest.getProductId()).get();
            product.setProductName(saveProductRequest.getProductName());
            product.setProductCompanyName(saveProductRequest.getProductcompanyName());
            product.setProductWeight(saveProductRequest.getProductWeight());
            product.setProductPrice(saveProductRequest.getProductPrice());
            product.setProductIsDeleted(false);
            product.setProductIsActive(true);
            productRepository.save(product);
            return "Updated sucessfully";
        } else {
            product product = new product();
            product.setProductName(saveProductRequest.getProductName());
            product.setProductCompanyName(saveProductRequest.getProductcompanyName());
            product.setProductWeight(saveProductRequest.getProductWeight());
            product.setProductPrice(saveProductRequest.getProductPrice());
            product.setProductIsDeleted(false);
            product.setProductIsActive(true);
            productRepository.save(product);
            return "Saved sucessfully";
        }
    }



    @Override
    public Object getAllByIsDeleted(String productName, Pageable pageable) {
        Page<product> products;
        if (productName != null && !productName.isEmpty()) {
            products = productRepository.findAllByProductName(productName ,pageable);
        } else {
            products = productRepository.getAllByDeleted(pageable);
        }
        return new pageDTO(products.getContent(), products.getTotalElements(), products.getNumber(), products.getTotalPages());
    }






    @Override
    public Object getAllByIsDeleted(String productName, String productcompanyName,  Double productWeight,Double productPrice, Pageable pageable) {
        Page<product> products;
        if (StringUtils.isNotBlank(productName)){
            productName=productName.toLowerCase();
        }
        if (StringUtils.isNotBlank(productcompanyName)){
            productcompanyName=productcompanyName.toLowerCase();
        }
        if (StringUtils.isNotBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight == null && productPrice == null) {
            System.out.println("search By productName");
            products = productRepository.getAllByProductName(productName, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isNotBlank(productcompanyName) && productWeight == null && productPrice == null) {
            System.out.println("search By ProductCompanyName");
            products = productRepository.getAllByProductCompanyName(productcompanyName, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight != null && productPrice == null) {
            System.out.println("search By productWeight ");
            products = productRepository.getAllByProductWeight(productWeight, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight == null && productPrice != null) {
            System.out.println("search By ProductPrice");
            products = productRepository.getAllByproductPrice(productPrice, pageable);
        } else if (StringUtils.isNotBlank(productName) && StringUtils.isNotBlank(productcompanyName) && productWeight == null && productPrice == null) {
            System.out.println("search By ProductNameAndProductCompanyName");
            products = productRepository.getAllByProductNameAndProductCompanyName(productName, productcompanyName, pageable);
        } else if (StringUtils.isNotBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight != null && productPrice == null) {
            System.out.println("search By ProductNameAndProductWeight");
            products = productRepository.getAllByProductNameAndProductWeight(productName, productWeight, pageable);
        } else if (StringUtils.isNotBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight == null && productPrice != null) {
            System.out.println("search By ProductNameAndProductPrice");
            products = productRepository.getAllByProductNameAndProductPrice(productName, productPrice, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isNotBlank(productcompanyName) && productWeight != null && productPrice == null) {
            System.out.println("search By ProductCompanyNameAndProductWeight");
            products = productRepository.getAllByProductCompanyNameAndProductWeight(productcompanyName, productWeight, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isNotBlank(productcompanyName) && productWeight == null && productPrice != null) {
            System.out.println("search By ProductCompanyNameAndProductPrice");
            products = productRepository.getAllByProductCompanyNameAndProductPrice(productcompanyName, productPrice, pageable);
        } else if (StringUtils.isBlank(productName) && StringUtils.isBlank(productcompanyName) && productWeight != null && productPrice != null) {
            System.out.println("search By ProductWeightAndProductPrice");
            products = productRepository.getAllByProductWeightAndProductPrice(productWeight, productPrice, pageable);
        }else if (StringUtils.isNotBlank(productName)&& StringUtils.isNotBlank(productcompanyName)&&productWeight!=null&&productPrice==null) {
            System.out.println("search By ProductNameAndProductCompanyNameAndProductWeight");
            products = productRepository.getAllByProductNameAndProductCompanyNameAndProductWeight(productName, productcompanyName, productWeight, pageable);
        }else if (StringUtils.isNotBlank(productName)&&StringUtils.isNotBlank(productcompanyName)&&productWeight==null&&productPrice!=null) {
            System.out.println("search By ProductNameAndProductCompanyNameAndProductPrice");
            products = productRepository.getAllByProductNameAndProductCompanyNameAndProductPrice(productName, productcompanyName, productPrice, pageable);
        }else if (StringUtils.isNotBlank(productName)&&StringUtils.isBlank(productcompanyName)&&productWeight!=null&&productPrice!=null) {
            System.out.println("search By ProductNameAndProductWeightAndProductPrice");
            products = productRepository.getAllByProductNameAndProductWeightAndProductPrice(productName, productWeight, productPrice, pageable);
        }else if (StringUtils.isBlank(productName)&&StringUtils.isNotBlank(productcompanyName)&&productWeight!=null&&productPrice!=null) {
            System.out.println("search By ProductCompanyNameAndProductWeightAndProductPrice");
            products = productRepository.getAllByProductCompanyNameAndProductWeightAndProductPrice(productcompanyName, productWeight, productPrice, pageable);
        }else if (StringUtils.isNotBlank(productName)&&StringUtils.isNotBlank(productcompanyName)&&productWeight!=null&&productPrice!=null){
            System.out.println("search By ProductNameAndProductCompanyNameAndProductWeightAndProductPrice");
            products = productRepository.getAllByProductNameAndProductCompanyNameAndProductWeightAndProductPrice(productName,productcompanyName,productWeight,productPrice,pageable);
        }else{
            products = productRepository.getAllByDeleted(pageable);
        }
        return new pageDTO(products.getContent(), products.getTotalElements(), products.getNumber(), products.getTotalPages());
    }



    @Override
    public product getById(Long productId) throws Exception {
        if(productRepository.existsById(productId)){
            product product=productRepository.findById(productId).get();
            return product;
        }else{
            throw new Exception("Product not found");
        }

    }

    @Override
    public List<product> getAllByIsDeleted() {
        List<product> products=productRepository.getAllByIsDeleted();
            return products;
    }

    @Override
    public String deleteById(Long productId) throws Exception {
        if (productRepository.existsById(productId)) {
            product product = productRepository.findById(productId).get();
            product.setProductIsDeleted(true);
           productRepository.save(product);
           return "deleted successfully";
        } else {
            throw new Exception("Product not found");
        }
    }

    @Override
    public String changeStatus(Long productId) throws Exception {
        if (productRepository.existsById(productId)) {
            product product = productRepository.findById(productId).get();
            if(product.getProductIsActive()){
                product.setProductIsActive(true);
                return "Product inactivated";
            }else{
                product.setProductIsActive(false);
                return "Product activated";
            }
        } else {
            throw new Exception("Product not found");
        }
    }
}
