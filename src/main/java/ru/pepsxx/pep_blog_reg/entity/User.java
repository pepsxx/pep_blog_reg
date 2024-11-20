package ru.pepsxx.pep_blog_reg.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String pass;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role_id")
    private UserRole userRole;
}
