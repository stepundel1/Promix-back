package com.nawerno.promyshia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promo {
    private Integer id;
    private String name;
    private String description;
    private String selectedCategory;
    private String imageLink;

}
