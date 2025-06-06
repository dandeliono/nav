package com.example.nav.controller;

import com.example.nav.entity.SiteSettings;
import com.example.nav.repository.SiteSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SiteSettingsController {

    @Autowired
    private SiteSettingsRepository repository;

    @GetMapping
    public SiteSettings get() {
        return repository.findById(1L).orElse(null);
    }

    @PutMapping
    public SiteSettings update(@RequestBody SiteSettings settings) {
        settings.setId(1L);
        return repository.save(settings);
    }
}
