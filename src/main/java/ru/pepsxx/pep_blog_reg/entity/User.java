package ru.pepsxx.pep_blog_reg.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String pass;
    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole;
}
