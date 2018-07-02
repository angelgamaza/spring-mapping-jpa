package com.gamaza.examples.springmappingjpa.service;

import com.gamaza.examples.springmappingjpa.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();
    UserDTO getOne(Integer id);
    UserDTO create(UserDTO userDTO);
    void update(Integer id, UserDTO userDTO);
    void delete(Integer id);

}
