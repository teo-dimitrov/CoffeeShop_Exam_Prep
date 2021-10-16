package com.example.coffeeshop_exam_prep.service;

import com.example.coffeeshop_exam_prep.model.Service.OrderServiceModel;
import com.example.coffeeshop_exam_prep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);
}
