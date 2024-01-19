package com.firstproject.demo5.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@Table(name = "demo5_product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_company_name")
    private String productCompanyName;

    @Column(name = "product_weight")
    private Double productWeight;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "product_is_deleted")
    private Boolean productIsDeleted;

    @Column(name = "product_is_active")
    private Boolean productIsActive;

    @CreationTimestamp
    @Column(name = "product_created_at",updatable = false)
    private LocalDateTime productCreatedAt;

    @UpdateTimestamp
    @Column(name = "prodcut_update_at")
    private LocalDateTime productUpdatedAt;

}
