package com.classactivity.classactivity.repository;

import com.classactivity.classactivity.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("select oS from Orders oS where oS.orderNumber = :number order by oS.orderId desc")
    List<Orders> findByNumber(long number);
}
