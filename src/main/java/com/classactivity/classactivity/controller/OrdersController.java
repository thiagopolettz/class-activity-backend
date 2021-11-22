package com.classactivity.classactivity.controller;

import com.classactivity.classactivity.entities.Orders;
import com.classactivity.classactivity.entities.Products;
import com.classactivity.classactivity.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersRepository repository;

    @PostMapping
    public ResponseEntity<Orders> save(@RequestBody Orders orders) {
        Orders newOrder = repository.save(orders);

        List<Products> products = newOrder.getProducts();

        boolean needResave = false;
        for (Products pS : products) {
            if (pS.getOrders() == null)
            {
                needResave = true;
                pS.setOrders(new Orders(newOrder.getOrderId()));
            }
        }
        if (needResave)
            newOrder = repository.save(newOrder);

        return ResponseEntity.ok(newOrder);
    }

    @GetMapping
    public List<Orders> findAll(@RequestParam(required = false, defaultValue = "0") long number) {
        if (number > 0) {
            return repository.findByNumber(number);
        }
        return repository.findAll();
    }

}
