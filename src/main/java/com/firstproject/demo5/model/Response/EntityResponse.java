package com.firstproject.demo5.model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntityResponse {
    private Object response;
    private Integer status;

}
