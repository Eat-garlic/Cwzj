package com.maoge.demo.productserver.service;

import com.maoge.demo.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> list();
    Product get(Long id);
}