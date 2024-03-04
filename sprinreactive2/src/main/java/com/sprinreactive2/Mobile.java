package com.sprinreactive2;

import org.springframework.data.annotation.Id;

@Entity
public class Mobile {

    @Id
    @Generate
    Integer id;

    String name;
    String manufacturer;

    Integer price;
}
