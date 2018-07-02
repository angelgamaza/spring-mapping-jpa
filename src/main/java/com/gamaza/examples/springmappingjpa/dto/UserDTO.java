package com.gamaza.examples.springmappingjpa.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String surnames;

}
