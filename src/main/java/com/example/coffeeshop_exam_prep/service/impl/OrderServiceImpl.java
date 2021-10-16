package com.example.coffeeshop_exam_prep.service.impl;

import com.example.coffeeshop_exam_prep.model.Service.OrderServiceModel;
import com.example.coffeeshop_exam_prep.model.entity.Order;
import com.example.coffeeshop_exam_prep.model.view.OrderViewModel;
import com.example.coffeeshop_exam_prep.repositoty.OrderRepository;
import com.example.coffeeshop_exam_prep.sec.CurrentUser;
import com.example.coffeeshop_exam_prep.service.CategoryService;
import com.example.coffeeshop_exam_prep.service.OrderService;
import com.example.coffeeshop_exam_prep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream().map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
