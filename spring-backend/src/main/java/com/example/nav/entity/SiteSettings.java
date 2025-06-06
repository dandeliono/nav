package com.example.nav.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SiteSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String logo;
    private String icp;
    private String status;

    // getters and setters omitted for brevity
}
