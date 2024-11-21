package ru.pepsxx.pep_blog_reg.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor // Без пустого конструктора не работает RequestBody
public class IdModel {
    private Long id;
}
