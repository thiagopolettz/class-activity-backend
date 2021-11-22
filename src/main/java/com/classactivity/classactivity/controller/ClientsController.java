package com.classactivity.classactivity.controller;

import com.classactivity.classactivity.entities.Clients;
import com.classactivity.classactivity.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientsController {

    @Autowired
    private ClientsRepository repository;

    @GetMapping
    public List<Clients> get(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Clients>save(@RequestBody Clients clients){
        Clients result = repository.save(clients);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{clientsId}")
    public void delete(@PathVariable("clientsId")Long clientsId){
        repository.deleteById(clientsId);
    }
    
}
