package com.firstproject.demo5.repository;

import com.firstproject.demo5.model.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface ProductRepository extends JpaRepository<product,Long> {

    @Query(value = "select * from demo5_product where product_is_deleted=false",nativeQuery = true)
    List<product> getAllByIsDeleted();



    @Query(value = "select * from demo5_product where product_is_deleted=false",nativeQuery = true)
    Page<product> getAllByDeleted(Pageable pageable);

    Page<product> findAllByProductName(String productName, Pageable pageable);

    @Query(value = "select p from product  as p where p.productName like %:productName% and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductName(String productName, Pageable pageable);

    @Query(value = "select p from product  as p where p.productCompanyName like %:productcompanyName% and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductCompanyName(String productcompanyName, Pageable pageable);

    @Query(value = "select p from product  as p where p.productWeight = :productWeight and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductWeight(Double productWeight, Pageable pageable);

    @Query(value = "select p from product as p where p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByproductPrice(Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productName like %:productName% and p.productCompanyName like %:productcompanyName% and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductCompanyName(String productName, String productcompanyName, Pageable pageable);

    @Query(value = "select p from product as p where p.productName like %:productName% and p.productWeight = :productWeight and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductWeight(String productName, Double productWeight, Pageable pageable);

    @Query(value = "select p from product  as p where p.productName like %:productName% and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductPrice(String productName, Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productCompanyName like %:productcompanyName% and p.productWeight = :productWeight and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductCompanyNameAndProductWeight(String productcompanyName, Double productWeight, Pageable pageable);

    @Query(value = "select p from product as p where p.productCompanyName like %:productcompanyName% and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductCompanyNameAndProductPrice(String productcompanyName, Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productWeight = :productWeight and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductWeightAndProductPrice(Double productWeight, Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productName like %:productName% and p.productCompanyName like %:productcompanyName% and p.productWeight = :productWeight and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductCompanyNameAndProductWeight(String productName, String productcompanyName, Double productWeight, Pageable pageable);

    @Query(value = "select p from product as p where p.productName like %:productName% and p.productCompanyName like %:productcompanyName% and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductCompanyNameAndProductPrice(String productName, String productcompanyName, Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productName like %:productName% and p.productWeight = :productWeight and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc")
    Page<product> getAllByProductNameAndProductWeightAndProductPrice(String productName, Double productWeight, Double productPrice, Pageable pageable);

    @Query(value = "select p from product as p where p.productCompanyName like %:productcompanyName% and p.productWeight = :productWeight and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductCompanyNameAndProductWeightAndProductPrice(String productcompanyName, Double productWeight, Double productPrice, Pageable pageable);

    @Query(value = " select p from product as p where p.productName like %:productName% and p.productCompanyName like %:productcompanyName% and p.productWeight = :productWeight and p.productPrice = :productPrice and p.productIsDeleted=false order by p.productCreatedAt desc ")
    Page<product> getAllByProductNameAndProductCompanyNameAndProductWeightAndProductPrice(String productName, String productcompanyName, Double productWeight, Double productPrice, Pageable pageable);
}
