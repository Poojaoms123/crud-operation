package com.firstproject.demo5.model.SaveRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveProductRequest{
    private Long productId;
    private String productName;
    private String productcompanyName;
    private Double productWeight;
    private Double productPrice;


}
