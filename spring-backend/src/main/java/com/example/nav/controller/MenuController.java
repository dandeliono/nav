package com.example.nav.controller;

import com.example.nav.entity.Menu;
import com.example.nav.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuRepository repository;

    @GetMapping
    public List<Menu> list() {
        return repository.findAll();
    }

    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return repository.save(menu);
    }

    @PutMapping("/{id}")
    public Menu update(@PathVariable Long id, @RequestBody Menu menu) {
        menu.setId(id);
        return repository.save(menu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
