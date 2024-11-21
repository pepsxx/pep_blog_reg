package ru.pepsxx.pep_blog_reg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserRole {

    public UserRole(Role role) {
        this.id = role;
        this.role = role;
    }

    @Id
    @Enumerated(EnumType.ORDINAL)
    Role id;
    @Enumerated(EnumType.STRING)
    Role role;
}
