package com.classactivity.classactivity.repository;

import com.classactivity.classactivity.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
