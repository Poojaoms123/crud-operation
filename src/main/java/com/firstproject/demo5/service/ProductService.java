package com.firstproject.demo5.service;

import com.firstproject.demo5.model.SaveRequest.SaveProductRequest;
import com.firstproject.demo5.model.product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    product getById(Long productId) throws Exception;

    List<product> getAllByIsDeleted();

    String deleteById(Long productId) throws Exception;

    String changeStatus(Long productId) throws Exception;

    Object saveOrUpdateProduct(SaveProductRequest saveProductRequest);

    Object getAllByIsDeleted(String productName, Pageable pageable);

    Object getAllByIsDeleted(String productName, String productcompanyName, Double productWeight, Double productPrice, Pageable pageable);
}
