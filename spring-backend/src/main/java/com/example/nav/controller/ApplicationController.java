package com.example.nav.controller;

import com.example.nav.entity.Application;
import com.example.nav.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository repository;

    @GetMapping
    public List<Application> list() {
        return repository.findAll();
    }

    @PostMapping
    public Application create(@RequestBody Application app) {
        return repository.save(app);
    }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id, @RequestBody Application app) {
        app.setId(id);
        return repository.save(app);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
