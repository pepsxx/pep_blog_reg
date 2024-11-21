package ru.pepsxx.pep_blog_reg.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "role")
public class UserRole {

    public UserRole(Role role) {
        this.id = role;
        this.name = role;
    }

    @Id
    @Enumerated(EnumType.ORDINAL)
    Role id;
    @Enumerated(EnumType.STRING)
    Role name;
}
