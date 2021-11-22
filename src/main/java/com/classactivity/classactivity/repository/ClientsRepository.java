package com.classactivity.classactivity.repository;

import com.classactivity.classactivity.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

}
