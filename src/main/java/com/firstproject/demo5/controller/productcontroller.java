package com.firstproject.demo5.controller;

import com.firstproject.demo5.model.Response.EntityResponse;
import com.firstproject.demo5.model.SaveRequest.SaveProductRequest;
import com.firstproject.demo5.model.product;
import com.firstproject.demo5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class productcontroller {
    @Autowired
    private ProductService productService;

    @GetMapping("/firstapi")
    public String firstapi() {
        return "working";
    }

    @PostMapping("/saveOrUpdateProduct")
    public ResponseEntity<?> saveOrUpdateProduct(@RequestBody SaveProductRequest SaveProductRequest) {
        return new ResponseEntity<>(productService.saveOrUpdateProduct(SaveProductRequest), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long productId) {
        try {
            return new ResponseEntity<>(new EntityResponse(productService.getById(productId), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    private ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0",required = false)Integer pageNo,
                                            @RequestParam(defaultValue = "30",required = false)Integer pageSize,
                                            @RequestParam(required = false)String productName,
                                            @RequestParam(required = false )String productcompanyName,
                                            @RequestParam(required = false)Double productWeight,
                                            @RequestParam(required = false)Double productPrice) {
        try {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return new ResponseEntity<>(new EntityResponse(productService.getAllByIsDeleted(productName,productcompanyName,productWeight,productPrice,pageable), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteById/{productId}")
    public ResponseEntity<?> deleteById(@PathVariable Long productId) {
        try {
            return new ResponseEntity<>(new EntityResponse(productService.deleteById(productId), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }

    @PutMapping("/changeStatus")
    public ResponseEntity<?> changeStatus(@RequestParam Long productId) throws Exception {
        try {
            return new ResponseEntity<>(new EntityResponse(productService.changeStatus(productId), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new EntityResponse(e.getMessage(), -1), HttpStatus.OK);
        }

    }
}
