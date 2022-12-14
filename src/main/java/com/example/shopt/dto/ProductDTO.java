package com.example.shopt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO {

    private Integer id;
    private String name;
    private String type;
    private float price;

}
